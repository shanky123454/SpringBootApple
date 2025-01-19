package in.com.resourceserver;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServer extends ResourceServerConfigurerAdapter {
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
        http.requestMatchers()
                .antMatchers("/demo/details","/demo/user")
                .and()
                .authorizeRequests()
                .antMatchers("/demo/details")
                .access("#oauth2.hasScope('read')and hasRole('ROLE_ADMIN')")
                .antMatchers("/demo/user")
                .access("#oauth2.hasScope('read')and hasRole('ROLE_USER')"); 
	}
	
	

}
