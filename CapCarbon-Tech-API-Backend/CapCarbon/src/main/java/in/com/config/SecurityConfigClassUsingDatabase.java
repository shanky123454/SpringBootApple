package in.com.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import in.com.model.Users;
import in.com.service.Usersssss;


@Configuration
public class SecurityConfigClassUsingDatabase {

	@Autowired
	public DataSource dataSource;

	
	@Autowired
	// public UserDetailsService users;
	 public Usersssss users; // BOTH WILL WORK 
 

	
	
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception
	{
	auth.userDetailsService(users).passwordEncoder(this.passwordEncoder());
	/*
	 * auth.jdbcAuthentication().passwordEncoder(this.passwordEncoder())
	 * .dataSource(dataSource); // JDBC AUTHENTICATION is not working 
	 */
	
	
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
		.hasRole("USER")
		.requestMatchers("/delete/{id}")
		.hasRole("ADMIN")
		.requestMatchers("/api/tourist/modify")
		.hasRole("USER")
//		.requestMatchers("/api/tourist/budgetModify/{id}/{hike}")
//		.hasRole("ADMIN")
		.requestMatchers("/api/tourist/home")
		.permitAll()
		.requestMatchers("/error/**").permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.formLogin()
		.and()
		.rememberMe()
		.and()
		.logout()
		.and()
		.exceptionHandling()
		.accessDeniedPage("/error")
		.and()
		.sessionManagement()
		.maximumSessions(5)
		.maxSessionsPreventsLogin(true);
		
		
		return http.build();
		
			
	}
	 @Bean
	 public BCryptPasswordEncoder passwordEncoder() { return new
			  BCryptPasswordEncoder(); }
	

	}
