package in.com.stockAmountController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.com.service.AmountServiceImpl;

@RestController
@RequestMapping(value = "/amount")
public class AmountController {

	@Autowired
	public AmountServiceImpl amountServiceImpl;
	
	@GetMapping(value = "/cal/{id}/{qty}" )
	public ResponseEntity<?> getPrice(@PathVariable Integer id, @PathVariable Integer qty){
	return amountServiceImpl.getTotalStockPrice(id,qty); 
	}
}
