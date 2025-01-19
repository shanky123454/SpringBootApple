package in.com.Main;

import java.time.LocalDate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "in.com")
public class AppConfig {
	
      static {
    	  System.out.println("AppConfig.static method()");
      }

	public AppConfig() {
		System.out.println("AppConfig.AppConfig()");
	}
	
	@Bean
	public LocalDate getdate()
	{
		LocalDate date = LocalDate.now();
		return date;
	}
      
}
