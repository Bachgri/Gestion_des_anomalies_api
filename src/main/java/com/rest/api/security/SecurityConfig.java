package com.rest.api.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.rest.api.filter.JWTAuthentificationFilter;
import com.rest.api.filter.JwtAuthorizationFilter;
import com.rest.api.service.AccountService;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	AccountService accs;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		 auth.userDetailsService(new UserDetailsService() {
			// pour spécifier l'endroit ou spring vas chercher utilisateur
			@Override
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				//System.err.println(username + " //**//  " + accs.loadUserByUserName(username).getPassword());//Debug
				Collection<GrantedAuthority> authorities = new ArrayList<>();
				accs.loadUserByUserName(username).getAppRoles().forEach(t ->{
					authorities.add(new SimpleGrantedAuthority(t.getRoleName()));
				});
				//return User de spring
				return new User(accs.loadUserByUserName(username).getUsername(), 
						accs.loadUserByUserName(username).getPassword(), authorities );
			}
		}); 
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.headers().frameOptions().disable();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.authorizeHttpRequests().antMatchers("/refreshToken").permitAll();
		http.authorizeHttpRequests().antMatchers("/login").permitAll();
		http.authorizeHttpRequests().antMatchers("/roles").permitAll();
		http.authorizeHttpRequests().antMatchers("/upload").permitAll();
		http.authorizeHttpRequests().antMatchers("/download").permitAll();
		http.authorizeHttpRequests().antMatchers("/Api/reclamations").permitAll();
		http.authorizeHttpRequests().antMatchers("/Api/reclamations/**").permitAll();
		http.authorizeHttpRequests().antMatchers("/Api/**/**").permitAll();
		
		//http.authorizeHttpRequests().antMatchers(HttpMethod.GET, "/clients").hasAnyAuthority("ADMIN", "USER");
		/*http.authorizeHttpRequests().antMatchers(HttpMethod.GET, "/roles").hasAnyAuthority("ADMIN");
		http.authorizeHttpRequests().antMatchers(HttpMethod.GET, "/villes").hasAnyAuthority("USER", "ADMIN");
		http.authorizeHttpRequests().antMatchers(HttpMethod.GET, "/villes/*").hasAnyAuthority("USER", "ADMIN");
		http.authorizeHttpRequests().antMatchers(HttpMethod.POST, "/villes").hasAnyAuthority("ADMIN");
		http.authorizeHttpRequests().antMatchers(HttpMethod.PUT, "/villes").hasAnyAuthority("ADMIN");
		http.authorizeHttpRequests().antMatchers(HttpMethod.DELETE, "/villes").hasAnyAuthority("ADMIN");*/
		
		/*http.authorizeHttpRequests().antMatchers(HttpMethod.GET,    "/reclamations").hasAnyAuthority(  "USER", "ADMIN");
		http.authorizeHttpRequests().antMatchers(HttpMethod.GET,    "/reclamations/*").hasAnyAuthority("USER", "ADMIN");
		http.authorizeHttpRequests().antMatchers(HttpMethod.POST,   "/reclamations").hasAnyAuthority(  "ADMIN", "USER");
		http.authorizeHttpRequests().antMatchers(HttpMethod.PUT,    "/reclamations").hasAnyAuthority(  "ADMIN","USER");
		http.authorizeHttpRequests().antMatchers(HttpMethod.DELETE, "/reclamations/*").hasAnyAuthority(  "ADMIN","USER");
 */
		
		/*http.authorizeHttpRequests().antMatchers(HttpMethod.GET, "/clients/**").hasAuthority("ADMIN");
		http.authorizeHttpRequests().antMatchers(HttpMethod.POST, "/clients/**").hasAuthority("ADMIN");
		http.authorizeHttpRequests().antMatchers(HttpMethod.PUT, "/clients/**").hasAuthority("ADMIN");// .... 
		http.authorizeHttpRequests().anyRequest().authenticated();*/
		http.addFilter(new JWTAuthentificationFilter(authenticationManagerBean()));
		http.addFilterBefore(new JwtAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
		
	}
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	
}
