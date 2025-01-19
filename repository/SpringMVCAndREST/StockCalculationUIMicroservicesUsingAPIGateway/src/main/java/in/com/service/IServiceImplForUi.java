package in.com.service;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class IServiceImplForUi implements IServiceforUi {

	@Override
	public String calculateTotalPrice(Integer id,Integer qty) {
		
		WebClient client = WebClient.create();
		String url = "http://localhost:8888/api/amount/amount/cal/{id}/{qty}";
		String entity = null;
		try {     
			 entity = client.get().uri(url,id,qty).accept(MediaType.APPLICATION_JSON).retrieve()
					.bodyToMono(String.class).block();
		
		}catch(Exception e) {
			String msg = "Entered Id is not correct";
		}
		
		 return entity;
	}  

}
