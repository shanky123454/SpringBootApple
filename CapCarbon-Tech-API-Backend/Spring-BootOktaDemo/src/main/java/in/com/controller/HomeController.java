package in.com.controller;

import java.security.Principal;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/demo")
public class HomeController {

	@PermitAll
    @GetMapping("/home")
    public String home() {
        return "Hello, home!"; 
    }
    
   // @PreAuthorize("hasRole('User')")
	  @GetMapping("/details")
	@RolesAllowed("User")
    public String getDetails() {
    	 return "details";
    }
    
   // @PreAuthorize("hasRole('Admin')")

    @GetMapping("/user")
	@RolesAllowed("Admin")
    public Authentication showUserDetails(Principal principal) {
    System.out.println("Logged in Details :: " + principal.getName());
    Authentication authentication = 
    SecurityContextHolder.getContext().getAuthentication();
    System.out.println("HomeController.showUserDetails()");
    return authentication;
    }
    

}