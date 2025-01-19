package in.com.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.com.request.PassangerInfo;
import in.com.response.TicketInfo;

@RestController
@RequestMapping(value = "/producer")
public class ProducerController {
	
	@GetMapping(value = "/booking/{id}")
	public ResponseEntity<TicketInfo> getInfo(@PathVariable Integer id)
	{
		TicketInfo info2 = new TicketInfo("booked", 455.43, new PassangerInfo(34, "Shashank", "raj", LocalDateTime.now(),"blr", "pune","12345"));
		return new ResponseEntity<>(info2, HttpStatus.OK);
	}

}
