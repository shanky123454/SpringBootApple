package in.com.ineuron;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="in.com.ineuron")
public class JavaMain {
	
	@Bean
	public Samosa getsamosa()
	{
		return new Samosa(); 
	}
	
	@Bean 
	public Emp getDetails()
	{
	Emp e = new Emp("shashank","bangalore");
	return e;
    }
	
}