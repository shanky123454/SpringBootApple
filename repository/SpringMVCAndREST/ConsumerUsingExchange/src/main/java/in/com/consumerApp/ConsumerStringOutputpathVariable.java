package in.com.consumerApp;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import in.com.model.Student;

@Component
public class ConsumerStringOutputpathVariable implements CommandLineRunner {     
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("shashank raj");
		
		RestTemplate restTemplate = new RestTemplate();
		String serviceUrl = "http://localhost:9996/first/producer/get/{id}";


	ResponseEntity<String> responseEntity = restTemplate.exchange(serviceUrl, HttpMethod.GET, null,String.class,7);
		
	//	ResponseEntity<Student> responseEntity = restTemplate.exchange(serviceUrl, HttpMethod.GET, null,Student.class,7);

		System.out.println("ResponseBody              :: " + responseEntity.getBody());
		System.out.println("ResponseStatus Code Value :: " + responseEntity.getStatusCodeValue());
		System.out.println("ResponseStatus Code       :: " + responseEntity.getStatusCode().name());
		System.out.println("********************************************************");


	}

}
