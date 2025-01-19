package in.com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Config {
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("shanky")
		.password(this.passwordEncoder().encode("shanky@123")).roles("ADMIN");
		
		auth.inMemoryAuthentication()
		.withUser("ritu")
		.password(this.passwordEncoder().encode("ritu@123")).roles("USER");
	
	}
	
	@Bean
	public SecurityFilterChain getFilterrrrrr(HttpSecurity http) throws Exception {
		
		http
        .csrf() 
        .disable().authorizeHttpRequests()
		.requestMatchers("/demo/home")
		.permitAll()
		
				/*
				 * .requestMatchers("/demo/details").hasAnyRole("USER")
				 * .requestMatchers("/demo/user").hasAnyRole("ADMIN")
				 */
		//NOT APPLICABLE DURING GMAIL AUTHETICATION
		
		.anyRequest()
		.authenticated()
		.and()
		.oauth2Login(Customizer.withDefaults())
		.formLogin(Customizer.withDefaults());
	
		return http.build();
		
	}

}
