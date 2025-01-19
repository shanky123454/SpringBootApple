package in.com.config;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(jsr250Enabled = true)
public class SecurityConfig {


void configure(HttpSecurity http) throws Exception {
 
http 
.authorizeHttpRequests(requests -> 
/*requests.requestMatchers("/demo/home")
		.permitAll()
		.requestMatchers("/demo/details").hasAnyAuthority("Admin")
		.requestMatchers("/demo/user").hasAnyRole("User")
		.anyRequest()  
		.authenticated())
		.oauth2Login(withDefaults());*/
 requests.anyRequest().permitAll());
		  }
	 				
	    

}
