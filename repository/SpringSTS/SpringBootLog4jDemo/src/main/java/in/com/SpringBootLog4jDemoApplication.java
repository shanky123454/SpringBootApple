package in.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.com.neuron.JdbcApp;

@SpringBootApplication
public class SpringBootLog4jDemoApplication {

	public static void main(String[] args) {
	ApplicationContext applicationContext =SpringApplication.run(SpringBootLog4jDemoApplication.class, args);
	JdbcApp app = applicationContext.getBean(JdbcApp.class);
	app.getResult();
	((ConfigurableApplicationContext) applicationContext).close();

	}

}
