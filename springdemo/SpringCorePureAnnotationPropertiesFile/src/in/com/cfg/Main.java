package in.com.cfg;

import java.time.LocalDateTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;

import in.com.CourierImplClass.BlueDart;
import in.com.CourierImplClass.DTDC;

@Configuration
@ComponentScan(basePackages = "in.com")
@PropertySource(value = "in/com/commons/application.properties")

public class Main {
 
	static {
		System.out.println("Main.static_method()");
		
	}
	
	public Main()
	{
		System.out.println("Main.Main()");
	}
	
	
	public DTDC getbean()
	{
		return new DTDC();
	}
	
	@Bean
	public LocalDateTime getdatetime()
	{
		return LocalDateTime.now();
	}

}
