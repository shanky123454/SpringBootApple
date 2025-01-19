package in.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import in.com.DTO.SpelDEmo;

@SpringBootApplication
public class SpringBootDemo42Application {

	public static void main(String[] args) {
	ApplicationContext applicationContext =	SpringApplication.run(SpringBootDemo42Application.class, args);
	SpelDEmo dEmo = applicationContext.getBean("speldemo",SpelDEmo.class);
	System.out.println(dEmo);
	}

}
