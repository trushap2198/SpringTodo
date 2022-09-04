package com.todo.firstwebapp.security;

import java.util.function.Function;
import static org.springframework.security.config.Customizer.withDefaults;

//import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration //direclty create spring beans
public class SecurityConfig {
	//LDPA OR DATABASE
	
	
	@Bean 	
	public InMemoryUserDetailsManager createUserDetailsManager() {
		UserDetails user1 = creatNewUser("trusha","blue");
		UserDetails user2 = creatNewUser("trusha2","blue2");
		
		return new InMemoryUserDetailsManager(user1, user2);
		
	}
	
	@Bean 
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(); 
	}
	
	public UserDetails creatNewUser(String name, String pass) {
			Function<String, String> ps = input->passwordEncoder().encode(input);
			UserDetails user = User.builder().passwordEncoder(ps)
			
			//UserDetails userdet = User.withDefaultPasswordEncoder()
			.username(name)
			.password(pass)
			.roles("USER", "ADMIN")
			.build();
		return user;
	}
	//
	@Bean
	public SecurityFilterChain filerchain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(
				auth -> auth.anyRequest().authenticated()
				); //authenticate all requests
		
		http.formLogin(withDefaults()); //
		
		http.csrf().disable();
		http.headers().frameOptions().disable();
		return http.build();
		
	}
}
