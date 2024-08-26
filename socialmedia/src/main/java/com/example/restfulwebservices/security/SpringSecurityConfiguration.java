package com.example.restfulwebservices.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

//		1) All requests should be authenticated
		http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());

//		2) If a request is not authenticated, a web page is show
		// http.formLogin(Customizer.withDefaults());
		http.httpBasic(Customizer.withDefaults());

//		3) CSRF --> POST, PUT
		http.csrf(custom -> custom.disable());

		http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

		return http.build();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		
		UserDetails user1 = User.withDefaultPasswordEncoder()
				.username("root")
				.password("root1")
				.roles("admin")
				.build();
		
		UserDetails user2 = User.withDefaultPasswordEncoder()
				.username("root1")
				.password("root12")
				.roles("user")
				.build();
		
		
		return new InMemoryUserDetailsManager(user1, user2);
	}

}
