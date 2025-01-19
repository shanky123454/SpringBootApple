package in.com.consumerApp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import in.com.model.Address;
import in.com.model.Student;

@Component
public class ConsumerPostingJsonData implements CommandLineRunner {     
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("shashank raj");
		
		RestTemplate restTemplate = new RestTemplate();
		
		String serviceUrl = "http://localhost:9996/first/producer/put";
		
		HttpHeaders headers = new HttpHeaders();
		
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		Student s = new Student(17, "chacha", "DBMS", new Address("bounsi", "india", 123456));
		
		//HttpEntity<Student> request = new HttpEntity<>(s);
		
		HttpEntity<Student> request = new HttpEntity<Student>(s, headers);
		ResponseEntity<Student> responseEntity = restTemplate.postForEntity(serviceUrl, request, Student.class);

		System.out.println("ResponseBody              :: " + responseEntity.getBody());
		System.out.println("ResponseStatus Code Value :: " + responseEntity.getStatusCodeValue());
		System.out.println("ResponseStatus Code       :: " + responseEntity.getStatusCode().name());
		System.out.println("********************************************************");


	}

}
