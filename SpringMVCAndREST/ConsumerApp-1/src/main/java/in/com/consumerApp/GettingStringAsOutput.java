package in.com.consumerApp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GettingStringAsOutput implements CommandLineRunner {     
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("shashank raj");
		
		RestTemplate restTemplate = new RestTemplate();
		String serviceUrl = "http://localhost:9996/first/producer/get";

		ResponseEntity<String> responseEntity = restTemplate.getForEntity(serviceUrl, String.class);

		System.out.println("ResponseBody              :: " + responseEntity.getBody());
		System.out.println("ResponseStatus Code Value :: " + responseEntity.getStatusCodeValue());
		System.out.println("ResponseStatus Code       :: " + responseEntity.getStatusCode().name());
		System.out.println("********************************************************");


	}

}
