package in.com.authorizationserver;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@Configuration 
@EnableAuthorizationServer 
public class AuthorizationServerConfigClass extends AuthorizationServerConfigurerAdapter{

    
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory()
		.withClient("redbus")
		.secret("{noop}redbus@123")
		.authorizedGrantTypes("authorization_code")
		.scopes("read")
		.authorities("CLIENT")
		.redirectUris("http://localhost:8090/showEmployees");
	}

}
