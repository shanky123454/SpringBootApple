package in.com.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import in.com.service.IServiceImplForUi;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class UiController {
	
	@Autowired
	public IServiceImplForUi forUi;
	
	
	/*
	 * @GetMapping(value = "/") public String getMapping() { return "register"; }
	 */
	 
	
	@PostMapping(value = "/calculate")
	public  String  getTotalAmount(Map<String,Object> model,HttpServletRequest request)
	{
		String Id =request.getParameter("id");
		String Qty =request.getParameter("qty");
		
   String  result = forUi.calculateTotalPrice(Integer.parseInt(Id),Integer.parseInt(Qty));
	model.put("message", result);
		
	return "display";
	}

}
