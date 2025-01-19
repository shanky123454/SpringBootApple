package in.com.controller;

import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import brave.sampler.Sampler;


@RestController
@RequestMapping(value = "/third")
public class Microservices3 {

	private final org.slf4j.Logger LOG =  LoggerFactory.getLogger(this.getClass());
	
	@Bean
    public Sampler alwaysSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }
	
	@GetMapping(value = "/microservice3")
	public String method3() {
		LOG.info("Inside method3");
		return "Hello World JavaInUse";
	}
	
}
