package in.com.cfg;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "in.com")
@Import(value = AppConfig1.class)
public class AppConfig {
	
	static {
		System.out.println("AppConfig.static method()");
	}

	public AppConfig()
	{
		System.out.println("AppConfig.AppConfig()");
	}
	

	
}
