package in.com.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class IServiceImplForUi implements IServiceforUi {

	@Override
	public ResponseEntity<?> calculateTotalPrice(Integer id,Integer qty) {
		
		WebClient client = WebClient.create();
		String url = "http://localhost:4444/amount/cal/{id}/{qty}";
		ResponseEntity<?> entity = null;
		try {     
			 String entity1 = client.get().uri(url,id,qty).accept(MediaType.APPLICATION_JSON).retrieve()
					.bodyToMono(String.class).block();
		entity =new ResponseEntity<>(entity1,HttpStatus.OK);
		}catch(Exception e) {
			String msg = "Entered Id is not correct sabdham rahe ";
			entity = new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
		}
		
		 return entity;
	}  

}
