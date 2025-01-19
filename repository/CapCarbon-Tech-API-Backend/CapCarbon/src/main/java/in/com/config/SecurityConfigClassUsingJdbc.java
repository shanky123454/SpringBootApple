package in.com.config;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import in.com.model.Users;


@Configuration
public class SecurityConfigClassUsingJdbc {

	@Autowired
	public DataSource dataSource;

	
	@Autowired
	public Users tourist;
	
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.inMemoryAuthentication().withUser("shanky")
		.password(this.passwordEncoder().encode("shanky@123"))
		.roles("ADMIN");
		
		auth.inMemoryAuthentication().withUser("ritu")
		.password(this.passwordEncoder().encode("ritu@123"))
		.roles("USER");
	}
	

	@Bean
	public SecurityFilterChain customFilterChain(HttpSecurity http) throws Exception {
		
		http.csrf().disable()
		.authorizeHttpRequests()
		.requestMatchers("/api/tourist/register")
		.hasRole("USER")
		.requestMatchers("/api/tourist/findAll")
		.hasRole("ADMIN")
		.requestMatchers("/api/tourist/find/{id}")
		.hasRole("ADMIN")
		.requestMatchers("/delete/{id}")
		.hasRole("ADMIN")
		.requestMatchers("/api/tourist/modify")
		.hasRole("USER")
//		.requestMatchers("/api/tourist/budgetModify/{id}/{hike}")
//		.hasRole("ADMIN")
		.requestMatchers("/api/tourist/home")
		.permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.formLogin();
		
		
		return http.build();
		
			
	}
	 @Bean public BCryptPasswordEncoder passwordEncoder() { return new
			  BCryptPasswordEncoder(); }
	

	}
