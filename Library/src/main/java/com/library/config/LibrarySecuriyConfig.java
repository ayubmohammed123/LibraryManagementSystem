package com.library.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class LibrarySecuriyConfig {
	@Bean
	public InMemoryUserDetailsManager userDetailsService() {
		UserDetails user = User.withDefaultPasswordEncoder()
				.username("mohammed")
				.password("ayub")
				.roles("USER")
				.build();
		return new InMemoryUserDetailsManager(user);
				
				
	}
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests((authz) -> authz
				//.requestMatchers("/student/getStudent")
				.anyRequest()
				.authenticated()
				)
				.httpBasic();
		return http.build();		
	}

}
