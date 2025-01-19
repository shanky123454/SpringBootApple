package in.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import in.com.feignClient.feignClient;

@Service
public class AmountServiceImpl implements IAmountService {

	@Autowired
	public feignClient client;

	@Override
	public ResponseEntity<?> getTotalStockPrice(Integer id,Integer qty) {
		Double totalPaisa=null;
		ResponseEntity<?> entity = null;
	try {
	 entity=client.getStockPrice(id);
	 if(entity.getStatusCode().value()==200) {
		Double d = (Double)entity.getBody();
		totalPaisa= d * qty;
		String response = "total cost" +" "+totalPaisa;
		entity =  new ResponseEntity<>(response,HttpStatus.OK);
	 } 
	}catch(Exception w) {
	String str ="plz enter the correct id of the company";
	entity = new ResponseEntity<>(str,HttpStatus.BAD_REQUEST);
	}
	return entity;

	}	
}
