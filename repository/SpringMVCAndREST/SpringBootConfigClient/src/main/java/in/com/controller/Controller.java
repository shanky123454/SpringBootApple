package in.com.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/first")
@RefreshScope
public class Controller {
	
	@Value("${msg:Hello default}")
	public String msg;
	
	@GetMapping(value = "/result")
	public String getResponse() {
		
		return  msg;
	}

}
