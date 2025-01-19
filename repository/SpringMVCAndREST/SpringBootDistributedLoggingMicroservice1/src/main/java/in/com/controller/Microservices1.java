package in.com.controller;


import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import brave.sampler.Sampler;


@RestController
@RequestMapping(value = "/first")
public class Microservices1 {

	private final org.slf4j.Logger LOG =  LoggerFactory.getLogger(this.getClass());
	
	RestTemplate restTemplate = new RestTemplate();
	
	
	@Bean
    public Sampler alwaysSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }
	
	
	@GetMapping(value = "/microservice1")
	public String method1() {
		LOG.info("Inside method1");
		String baseUrl = "http://localhost:8081/second/microservice2";
		String response = (String) restTemplate.exchange(baseUrl, HttpMethod.GET, null, String.class).getBody();
		LOG.info("The response received by method1 is " + response);
		return response;
	}
	
}

