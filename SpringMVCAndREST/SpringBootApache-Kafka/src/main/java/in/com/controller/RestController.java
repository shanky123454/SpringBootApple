package in.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.com.kafkaproducer.KafkaProducer;

@org.springframework.web.bind.annotation.RestController
@RequestMapping(value = "/test")
public class RestController {
	
	@Autowired
	private KafkaProducer kafkaProducer;

    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message){
       for(int i=0 ;i< 50;i++) {
    	   kafkaProducer.sendMessage(message);
       }
        return ResponseEntity.ok("Message sent to kafka topic");
    }

}
