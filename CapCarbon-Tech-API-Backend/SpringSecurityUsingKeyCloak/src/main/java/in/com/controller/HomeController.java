package in.com.controller;

import java.security.Principal;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class HomeController {

	@PermitAll
    @GetMapping("/home")
    public String home() {
        return "Hello, home!";
    }
    
	@RolesAllowed("User")
    @GetMapping("/details")
    public String getDetails() {
    	 return "details";
    }
    
	@RolesAllowed("Admin")
    @GetMapping("/user")
    public Authentication showUserDetails(Principal principal) {
    System.out.println("Logged in Details :: " + principal.getName());
    Authentication authentication = 
    SecurityContextHolder.getContext().getAuthentication();
    System.out.println("HomeController.showUserDetails()");
    return authentication;
    }
    

}