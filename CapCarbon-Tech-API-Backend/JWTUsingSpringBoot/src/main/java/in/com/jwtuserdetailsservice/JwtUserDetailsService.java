package in.com.jwtuserdetailsservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import in.com.securityconfig.WebSecurityConfig;

@Configuration
public class JwtUserDetailsService implements UserDetailsService {

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		if ("shashank".equals(username)) {
		return User.builder().username("shashank")
				.password(WebSecurityConfig.passwordEncoder().encode("shanky@123"))
				.disabled(false) 
	        	.accountExpired(false)
	        	.accountLocked(false)
	        	.credentialsExpired(false)
	        	.roles("ADMIN")
				.build(); 
	}
		else if ("ritu".equals(username)) {
		return User.builder().username("ritu")
				.password(WebSecurityConfig.passwordEncoder().encode("ritu@123"))
				.disabled(false) 
	        	.accountExpired(false)
	        	.accountLocked(false)
	        	.credentialsExpired(false)
	        	.roles("USER")
				.build(); 
		
	}
		else throw new UsernameNotFoundException("User not found with username: " + username);
	}
	
	@Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
        return builder.getAuthenticationManager();
    }
}
