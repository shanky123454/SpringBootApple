package in.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication 
public class SpringBootOktaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootOktaDemoApplication.class, args);
	}

}   
