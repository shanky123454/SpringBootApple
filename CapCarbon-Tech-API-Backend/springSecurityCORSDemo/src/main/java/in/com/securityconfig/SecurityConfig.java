package in.com.securityconfig;

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
public class SecurityConfig {
	
	 @Bean
	 public BCryptPasswordEncoder passwordEncoder() {
		 return new BCryptPasswordEncoder();
		 }
	
	@Autowired
	   public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("shanky").password(this.passwordEncoder().encode("shanky@123"))
		.authorities("ADMIN","USER");
		
		
		auth.inMemoryAuthentication()
		.withUser("ritu").password(this.passwordEncoder().encode("ritu@123"))
		.authorities("USER");
	}
	
	@Bean
	public SecurityFilterChain getSecurity(HttpSecurity http) throws Exception {
		
		http.
		csrf().disable().
		authorizeHttpRequests()
		.requestMatchers("/demo/detail")
		.hasAnyAuthority("ADMIN")
		.requestMatchers("/demo/register")
		.hasAuthority("USER")
		.requestMatchers("/demo/home")
		.permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.formLogin();
		
		return http.build();
		
	}

}
