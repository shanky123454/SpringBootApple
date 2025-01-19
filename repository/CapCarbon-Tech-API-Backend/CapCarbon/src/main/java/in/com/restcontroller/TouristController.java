package in.com.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.com.model.Users;
import in.com.service.IUsersMgmtService;


@RestController
@RequestMapping("/api/tourist")
public class TouristController {

	@Autowired
	private IUsersMgmtService service;

	@PostMapping("/register")
	public ResponseEntity<String> enrollTourist(@RequestBody Users tourist) {

		String resultMsg = service.registerTourist(tourist);
		return new ResponseEntity<String>(resultMsg, HttpStatus.OK);

	}

	@GetMapping("/findAll")
	public ResponseEntity<?> displayTouristDetails() {

		List<Users> list = service.fetchAllTourist();
		return new ResponseEntity<List<Users>>(list, HttpStatus.OK);

	}
	
	@GetMapping("/home")
	public ResponseEntity<?> displayHomePage() {

		String res = "WELCOME TO CAPcARBON";
		return new ResponseEntity<String>(res, HttpStatus.OK);

	}

	@GetMapping("/find/{id}")
	public ResponseEntity<?> displayTouristById(@PathVariable("id") Integer id) {

		Users tourist = service.fetchTouristById(id);
		return new ResponseEntity<Users>(tourist, HttpStatus.OK);

	}

	@PutMapping("/modify")
	public ResponseEntity<String> modifytourist(@RequestBody Users tourist) {

		String msg = service.updateTouristByDetails(tourist);
		return new ResponseEntity<String>(msg, HttpStatus.OK);

	}

	/*
	 * @PatchMapping("/budgetModify/{id}/{hike}") public ResponseEntity<String>
	 * modifytouristBudgetById(@PathVariable("id") Integer id,
	 * 
	 * @PathVariable("hike") Float hikeAmt) {
	 * 
	 * String msg = service.updateTouristById(id, hikeAmt); return new
	 * ResponseEntity<String>(msg, HttpStatus.OK);
	 * 
	 * }
	 */

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> removeTouristById(@PathVariable("id") Integer id) {
		String msg = service.deleteTouristById(id);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
}
