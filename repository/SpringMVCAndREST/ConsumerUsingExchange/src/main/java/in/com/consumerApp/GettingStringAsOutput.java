package in.com.consumerApp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import in.com.model.Student;

@Component
public class GettingStringAsOutput implements CommandLineRunner {     
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("shashank raj");
		
		RestTemplate restTemplate = new RestTemplate();
		String serviceUrl = "http://localhost:9996/first/producer/get";

	//	String responseEntity = restTemplate.getForObject(serviceUrl, String.class, 7);
	//	System.out.println(responseEntity);
		
		ResponseEntity<String> responseEntity = restTemplate.exchange(serviceUrl, HttpMethod.GET, null,String.class);

	//	ResponseEntity<Student> responseEntity = restTemplate.exchange(serviceUrl, HttpMethod.GET, null,Student.class);

		System.out.println("ResponseBody              :: " + responseEntity.getBody());
		System.out.println("ResponseStatus Code Value :: " + responseEntity.getStatusCodeValue());
		System.out.println("ResponseStatus Code       :: " + responseEntity.getStatusCode().name());
		System.out.println("********************************************************");


	}

}
