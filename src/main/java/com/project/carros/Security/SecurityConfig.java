package com.project.carros.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
	@Autowired
	@Qualifier("userDetailsService")
	private UserDetailsService UserDetailsService;
	
	 @Override
	protected void configure(HttpSecurity http) throws Exception {
		 http
		    .authorizeRequests()
		    .anyRequest()
		        .authenticated()
		        .and()
		        .httpBasic()
		             .and()
		              .csrf().disable();
 	}
	 
	 @Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		 
		 BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		 
		 auth.userDetailsService(UserDetailsService).passwordEncoder(encoder);
		     
  	}
}
