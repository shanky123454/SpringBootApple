package in.com.controller;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class HomeController {

    @GetMapping("/home")
    public String home() {
        return "Hello, home!";
    }
    
    @GetMapping("/details")
    public String getDetails() {
    	 return "details of shashank";
    }
    
    @GetMapping("/user")
    public Authentication showUserDetails(Principal principal) {
    System.out.println("Logged in Details :: " + principal.getName());
    Authentication authentication = 
    SecurityContextHolder.getContext().getAuthentication();
    System.out.println("HomeController.showUserDetails()");
    return authentication;
    }
    

}