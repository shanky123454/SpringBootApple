package in.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerServiceRegistryApplication.class, args);
	}

}
