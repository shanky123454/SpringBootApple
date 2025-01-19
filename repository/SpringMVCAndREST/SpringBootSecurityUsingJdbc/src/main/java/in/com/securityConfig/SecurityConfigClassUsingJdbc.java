package in.com.securityConfig;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfigClassUsingJdbc {

	@Autowired
	public DataSource dataSource;
	
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder())
		.dataSource(dataSource)
		/*
		 * .usersByUsernameQuery
		 * ("select username,password,enabled from users where username=?")
		 * .authoritiesByUsernameQuery
		 * ("select username,authority from authorities where username=?")
		 */
		;	
	}
	
	
	@Bean
	public SecurityFilterChain customFilterChain(HttpSecurity http) throws Exception {
		
		http.csrf().disable()
		.authorizeHttpRequests()
		.requestMatchers("/api/admin")
		.hasRole("ADMIN")
		.requestMatchers("/api/user")
		.hasRole("USER")
		.requestMatchers("/api/normal")
		.permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.formLogin();
		
		
		return http.build();
		
			
	}
	

	}
