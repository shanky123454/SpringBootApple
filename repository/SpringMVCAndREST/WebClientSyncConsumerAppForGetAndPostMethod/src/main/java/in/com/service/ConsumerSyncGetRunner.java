package in.com.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import in.com.response.TicketInfo;

@Component
public class ConsumerSyncGetRunner implements CommandLineRunner {
	
	private static final String REST_END_POINT = 
			"http://localhost:9996/producer/booking/{id}";

	@Override
	public void run(String... args) throws Exception {
		
		 WebClient webClient = WebClient.create();
		 
		 System.out.println("***Synchronous: Restcall started  for get ******");
		 
	TicketInfo response = webClient.get().uri(REST_END_POINT,5).accept(MediaType.APPLICATION_JSON).
		 retrieve().bodyToMono(TicketInfo.class).block();
		 
		 System.out.println(response);
		 
		 System.out.println("****Synchronous: Restcall ended  for get ******");

	}

}
