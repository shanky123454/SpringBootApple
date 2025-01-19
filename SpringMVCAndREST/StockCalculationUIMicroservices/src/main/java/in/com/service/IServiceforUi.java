package in.com.service;

import org.springframework.http.ResponseEntity;

public interface IServiceforUi {

	public  ResponseEntity<?>  calculateTotalPrice(Integer id,Integer qty);
}
