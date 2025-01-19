package in.com.service;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import in.com.request.PassangerInfo;
import in.com.response.TicketInfo;

@Component
public class ConsumerASyncPostRunner implements CommandLineRunner {
	
	private static final String REST_END_POINT = 
			"http://localhost:9996/AsyncApp/Asyncproducer/register";

	@Override
	public void run(String... args) throws Exception {
		
		 WebClient webClient = WebClient.create();
		 
		 System.out.println("***ASynchronous: Restcall started  for post******");
		 
		 PassangerInfo info = new PassangerInfo(93, "sam", "baba", LocalDateTime.now(), "blr", "mzp","12678");
	webClient.post().uri(REST_END_POINT, info).accept(MediaType.APPLICATION_JSON).
			body(BodyInserters.fromValue(info)) .retrieve().bodyToMono(TicketInfo.class)
			.subscribe(ConsumerASyncPostRunner::myResponse);

		 
		 System.out.println("****ASynchronous: Restcall ended  for post ******");

	}
	public static void myResponse(TicketInfo info) {
		System.out.println(info);
	}

}
