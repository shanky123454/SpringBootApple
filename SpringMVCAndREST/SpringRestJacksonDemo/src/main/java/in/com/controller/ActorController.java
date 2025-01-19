package in.com.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import in.com.model.Actor;

@RestController
@RequestMapping(value = "/reg")
public class ActorController {

	@PostMapping(value = "/actor", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Actor> setActorDetails(@RequestBody Actor actor){
		
		System.out.println(actor);
		return new ResponseEntity<Actor>(actor, HttpStatus.OK);
	}
}
