package in.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import in.com.service.IServiceImplForUi;
import jakarta.servlet.http.HttpServletRequest;

@RestController
public class UiController {
	
	@Autowired
	public IServiceImplForUi forUi;
	
	
	
	  @RequestMapping(value = "/index")
	  public ModelAndView getMapping(ModelAndView modelAndView) {
		  modelAndView.setViewName("register");
		  return modelAndView;
	  }
	 
	 
	
	@PostMapping(value = "/calculate")
	public  ResponseEntity<?>  getTotalAmount(HttpServletRequest request)
	{
		String Id =request.getParameter("id");
		String Qty =request.getParameter("qty");
		
		 ResponseEntity<?> result = forUi.calculateTotalPrice(Integer.parseInt(Id),Integer.parseInt(Qty));
		 
		
	return result;
	}

}
