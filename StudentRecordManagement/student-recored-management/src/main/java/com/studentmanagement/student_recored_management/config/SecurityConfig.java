package com.studentmanagement.student_recored_management.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.studentmanagement.student_recored_management.service.UserService;

@Configuration
public class SecurityConfig {
	@Autowired
	private UserService us;
	
	public SecurityConfig(UserService us) {
		this.us = us;
	}
	
	@Bean
	public SecurityFilterChain securityfilterChain(HttpSecurity http) throws Exception{
		http.csrf().disable().authorizeHttpRequests(auth -> auth
				.requestMatchers("/api/auth/**").permitAll()
				.requestMatchers("/api/students/**").authenticated()
				)
		.httpBasic();
		return http.build();
	}
		
		@Bean
	    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
	        return http.getSharedObject(AuthenticationManagerBuilder.class)
	                   .userDetailsService(us)
	                   .passwordEncoder(passEncoder())
	                   .and()
	                   .build();
	    }
		
		@Bean
		public PasswordEncoder passEncoder() {
			return new BCryptPasswordEncoder();
		}

}
