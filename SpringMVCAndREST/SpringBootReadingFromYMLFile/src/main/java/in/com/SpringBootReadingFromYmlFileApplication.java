package in.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import in.com.prop.Prop;

@SpringBootApplication
@EnableConfigurationProperties(Prop.class)
public class SpringBootReadingFromYmlFileApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootReadingFromYmlFileApplication.class, args);
	}

}
