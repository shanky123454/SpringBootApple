package in.com.controller;

import java.time.Duration;
import java.time.LocalDate;
import java.util.stream.Stream;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.com.model.StudentEvents;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@RestController
@RequestMapping(value = "/reactive")
public class MainController {
	
	@GetMapping(value = "/mono",produces = "application/json")
	public ResponseEntity<Mono<StudentEvents>> getMonoResponse(){
		
		StudentEvents events = new StudentEvents("SHASHANK", LocalDate.now());
		
		Mono<StudentEvents> mono = Mono.just(events);
		
		return new ResponseEntity<>(mono,HttpStatus.OK);
		 
	}
	

	@GetMapping(value = "/flux",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public ResponseEntity<Flux<StudentEvents>> getFluxResponse(){
		
		StudentEvents events = new StudentEvents("SHASHANK", LocalDate.now());
		
	Stream<StudentEvents> stream = Stream.generate(()->events);
	
	Flux<StudentEvents> flux = Flux.fromStream(stream);
	
	Flux<Long> interval = Flux.interval(Duration.ofMillis(20));
		
	Flux<Tuple2<Long,StudentEvents>> zip = Flux.zip(interval, flux);
		
		Flux<StudentEvents> flux2 = zip.map(Tuple2::getT2);
		return new ResponseEntity<>(flux2,HttpStatus.OK);
		 
	}
	
	

}
