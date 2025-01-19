package in.com.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import in.com.response.TicketInfo;

@Component
public class ConsumerASyncGetRunner implements CommandLineRunner {
	
	private static final String REST_END_POINT = 
			"http://localhost:9996/AsyncApp/Asyncproducer/booking/{id}";

	@Override
	public void run(String... args) throws Exception {
		
		 WebClient webClient = WebClient.create();
		 
		 System.out.println("***ASynchronous: Restcall started  for get ******");
		 
	webClient.get().uri(REST_END_POINT,5).accept(MediaType.APPLICATION_JSON).
		 retrieve().bodyToMono(TicketInfo.class).subscribe(ConsumerASyncGetRunner::myResponse);

		 System.out.println("****ASynchronous: Restcall ended  for get ******");

	}
	
	public static void myResponse(TicketInfo response) {
		System.out.println(response);
	}

}
