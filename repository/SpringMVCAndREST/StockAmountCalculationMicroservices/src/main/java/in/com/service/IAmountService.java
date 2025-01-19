package in.com.service;

import org.springframework.http.ResponseEntity;

public interface IAmountService {

	public ResponseEntity<?> getTotalStockPrice(Integer qty, Integer id);
}
