package com.gcu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.gcu.business.UserBusinessService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	@Autowired
	private UserBusinessService service;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable()
		.httpBasic()
		.and()
		.authorizeRequests()
			.antMatchers("/", "/index.html", "/orders", "/product", "/products/**")
				.authenticated()
				.and()
		.authorizeRequests()
				.antMatchers("/images/**", "/registration").permitAll()
				.anyRequest().authenticated()
				.and()
		.formLogin()
			.loginPage("/session/login")
			.usernameParameter("email")
			.passwordParameter("password")
			.permitAll()
			.defaultSuccessUrl("/", true)
			.and()
		.logout()
			.logoutUrl("/session/logout")
			.invalidateHttpSession(true)
			.clearAuthentication(true)
			.permitAll()
			.logoutSuccessUrl("/");
	}
	
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception{
//		auth.inMemoryAuthentication()
//			.withUser("test").password("{noop}test").roles("USER");
		auth.userDetailsService(service)
		.passwordEncoder(passwordEncoder);
		
	}
}
