package in.com.response;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HELLO-SERVICE")
public interface HelloServiceIntegrated {
	
	@GetMapping(value = "/Hello/hello/{name}")
	public String invokeHelloService(@PathVariable(value = "name") String name);

}
