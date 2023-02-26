package com.green.nowon.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@EnableWebSecurity
public class WebSecurityConfig  {
	
	@Bean
	MyUserDetailsService customUserDetailsService() {
		return new MyUserDetailsService();
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.authorizeRequests(authorize -> authorize
					.antMatchers("/css/**","/js/**","/images/**","/webjars/**","/files/**","/message/**").permitAll()
					.antMatchers("/","/signup","/signup2","/customer/**","/item/**","/menu-list2/**","/menu-list/**","/my-websocket/**","/common/**").permitAll()
					.antMatchers("/admin/**").hasRole("ADMIN")
					.anyRequest().authenticated()
			)
			.formLogin(formLogin->formLogin
					.loginPage("/signin")
					.loginProcessingUrl("/member/login")//form태그의 action
					.usernameParameter("email")//username ->email
					.passwordParameter("pass") //password -> pass
					.permitAll()
					)
			.logout(logout->logout
						.logoutSuccessUrl("/")
					)
			
			
				.csrf(csrf->csrf.disable())
				
			;
		return http.build();
	}
}

