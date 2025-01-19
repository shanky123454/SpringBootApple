package in.com.prop;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
 
import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "demo.properties")
@Data
public class Prop {

	public  String greetMsg;
	public  String testMsg;
	public  String welcomeMsg;

}
