package com.petarjk.springboot.restapi.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/users").hasRole("EMPLOYEE")
				.antMatchers(HttpMethod.GET, "/api/users/**").hasRole("EMPLOYEE")
				.antMatchers(HttpMethod.POST, "/api/users").hasAnyRole("MANAGER", "ADMIN")
				.antMatchers(HttpMethod.POST, "/api/users/**").hasAnyRole("MANAGER", "ADMIN")
				.antMatchers(HttpMethod.PUT, "/api/users").hasAnyRole("MANAGER", "ADMIN")
				.antMatchers(HttpMethod.PUT, "/api/users/**").hasAnyRole("MANAGER", "ADMIN")
				.antMatchers(HttpMethod.DELETE, "/api/users/**").hasRole("ADMIN").and().httpBasic().and().csrf()
				.disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

}
