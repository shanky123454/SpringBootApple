package in.com.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import in.com.service.Usersssss;


@Configuration
@EnableWebSecurity
public class SecurityConfigClassUsingDatabase {

	@Autowired
	public DataSource dataSource;
	
	
	  @Autowired
	  public Usersssss usersssss;
	 
	  
		/*
		 * 
		 * @Bean 
		 * UserDetailsService detailsService() 
		 * { 
		 * return new Usersssss();
		 *  }
		 *  
		 */
	 
	  
		/*
		 * @Bean
		 *  DaoAuthenticationProvider authenticationProvider() {
		 * DaoAuthenticationProvider authenticationProvider = new
		 * DaoAuthenticationProvider();
		 * 
		 * authenticationProvider.setUserDetailsService(this.detailsService());
		 * authenticationProvider.setPasswordEncoder(this.passwordEncoder());
		 * 
		 * return authenticationProvider; }
		 */
	 
	
	
	@Autowired
	public void config(AuthenticationManagerBuilder auth) throws Exception
	{
	   //auth.authenticationProvider(authenticationProvider());
		
	
	  auth.userDetailsService(usersssss).passwordEncoder(this.passwordEncoder());
	 
		 
	}
	

	@Bean
	public SecurityFilterChain customFilterChain(HttpSecurity http) throws Exception {
		
		http.csrf().disable()
		.authorizeHttpRequests()
		.requestMatchers("/api/tourist/register")
		.hasAuthority("USER")
		.requestMatchers("/api/tourist/findAll")
		.hasAuthority("ADMIN")
		.requestMatchers("/api/tourist/find/{id}")
		.hasAuthority("USER")
		.requestMatchers("/delete/{id}")
		.hasAuthority("ADMIN")
		.requestMatchers("/api/tourist/modify")
		.hasAuthority("USER")
//		.requestMatchers("/api/tourist/budgetModify/{id}/{hike}")
//		.hasRole("ADMIN")
		.requestMatchers("/api/tourist/home")
		.permitAll()
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
		
		
		return http.getOrBuild();
		
			
	}
	 @Bean
	 public BCryptPasswordEncoder passwordEncoder() { return new
			  BCryptPasswordEncoder(); }
	

	}
