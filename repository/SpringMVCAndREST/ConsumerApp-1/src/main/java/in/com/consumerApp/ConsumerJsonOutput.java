package in.com.consumerApp;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import in.com.model.Student;

@Component
public class ConsumerJsonOutput implements CommandLineRunner {     
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("shashank raj");
		
		RestTemplate restTemplate = new RestTemplate();
		String serviceUrl = "http://localhost:9996/first/producer/getting/{id}";
		
		Map<String,Object> map = new HashMap<>();
		map.put("id",01);

		ResponseEntity<Student> responseEntity = restTemplate.getForEntity(serviceUrl, Student.class,map);

		System.out.println("ResponseBody              :: " + responseEntity.getBody());
		System.out.println("ResponseStatus Code Value :: " + responseEntity.getStatusCodeValue());
		System.out.println("ResponseStatus Code       :: " + responseEntity.getStatusCode().name());
		System.out.println("********************************************************");


	}

}
