package com.rest.api.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class JwtAuthorizationFilter extends OncePerRequestFilter {
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String jwtAuthorizationToken = request.getHeader("Authorization");
		if(jwtAuthorizationToken!=null && jwtAuthorizationToken.startsWith("Bearer ")) {
			try {
				String jwt = jwtAuthorizationToken.substring(7);
				System.out.println(jwt);
				// parse the jwt 
				Algorithm algo = Algorithm.HMAC256("oualid_bachgri@2001");
				JWTVerifier jwtVerifier = JWT.require(algo).build();   
				DecodedJWT jwtDecode =  jwtVerifier.verify(jwt);
				String username = jwtDecode.getSubject();
				String roles = jwtDecode.getClaim("roles").asString()	;//.asArray(String.class);
				System.err.println(jwtDecode.getClaims());
				
				/*
				Claims claims = Jwts.parser().setSigningKey("oualid_bachgri@2001").parseClaimsJws(jwt).getBody();
				
				String[] roles = (String[]) claims.get("roles");
				*/
				System.err.println("role = "+roles);
				/*Claims claims = Jwts.parser().setSigningKey("oualid_bachgri@2001").parseClaimsJws(jwt).getBody();
				
				String[] roles1 = claims.get("roles", String[].class);
				System.out.println("username : " + username);
				System.out.println("roles : "  + roles1);*/
				// authentiier l'user
				List<GrantedAuthority> auths = new ArrayList<>();
				/*for (String role : roles) {*/
					auths.add(new SimpleGrantedAuthority(roles));
				/*}*/
				UsernamePasswordAuthenticationToken user = new UsernamePasswordAuthenticationToken(username,null,  auths);
				SecurityContextHolder.getContext().setAuthentication(user);
				// Auth()->user()
				filterChain.doFilter(request, response);
				
			}catch(Exception e) {
				System.err.println("Problème lors de décodage de JWT JWT Authehorization");
				response.setHeader("Erreur", e.getMessage());
				response.sendError(HttpServletResponse.SC_FORBIDDEN);// http servlet
				
			}
		}else {
			filterChain.doFilter(request, response);// tu peux passer, mais 
		}
	}
}
