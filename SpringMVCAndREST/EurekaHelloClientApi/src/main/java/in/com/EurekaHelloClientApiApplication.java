package in.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EurekaHelloClientApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaHelloClientApiApplication.class, args);
	}

}
