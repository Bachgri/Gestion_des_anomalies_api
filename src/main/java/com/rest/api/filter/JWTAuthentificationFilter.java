package com.rest.api.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper; 

public class JWTAuthentificationFilter extends UsernamePasswordAuthenticationFilter {
	
	private AuthenticationManager authenticationManager;
	
	public JWTAuthentificationFilter(AuthenticationManager authenticationManager) {
		super();
		this.authenticationManager = authenticationManager;
	}
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		String username = request.getParameter("username"),
			   password = request.getParameter("password");
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
		System.out.println(username + "  " + password );
		return authenticationManager.authenticate(authenticationToken);//
	}
	
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,Authentication authResult) 
			throws IOException, ServletException {
		System.out.println("i'm in the succefull authentication method");
		User user = (User) authResult.getPrincipal(); 
		Algorithm algo = Algorithm.HMAC256("oualid_bachgri@2001");
		ArrayList<String> roleNames = new ArrayList<>();
		for (GrantedAuthority role : user.getAuthorities()) {
			roleNames.add(role.getAuthority());
		}
		String[] roles = Arrays.copyOf(user.getAuthorities().stream().map(t -> t.getAuthority()).toArray(), user.getAuthorities().size(), String[].class);

		String jwtAccessToken = JWT.create()
		    .withSubject(user.getUsername())
		    .withExpiresAt(new Date(System.currentTimeMillis()+50*60*1000))
		    .withIssuer(request.getRequestURL().toString())
		    .withClaim("roles", roles[0]) 
		    .sign(algo);
		String jwtRefrechToken = JWT.create()
			    .withSubject(user.getUsername())
			    .withExpiresAt(new Date(System.currentTimeMillis()+150*60*1000))
			    .withIssuer(request.getRequestURL().toString()) 
			    .sign(algo);
		Map<String, String> idToken = new HashMap<>();
		idToken.put("access-token", jwtAccessToken);
		idToken.put("refresh-toekn", jwtRefrechToken);
		idToken.put("role", roles[0]);
		new ObjectMapper().writeValue(response.getOutputStream(), idToken);
		response.setContentType("application/json");
		response.setStatus(200);
		System.out.println("Acces token : "+idToken );	
		
		
	}
}
