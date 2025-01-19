package in.com.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import in.com.securityconfig.SecurityConfig;

@SpringBootApplication
public class SecurityApplication implements CommandLineRunner{
	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}

    @Autowired
    public DataSource dataSource;
    
	@Override
	public void run(String... args) throws Exception {
		SecurityConfig config = new SecurityConfig();
	config.userDetailsManager(dataSource);		
	}

	
}
