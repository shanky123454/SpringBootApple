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
@RequestMapping(value = "/second")
public class Microservices2 {

	private final org.slf4j.Logger LOG =  LoggerFactory.getLogger(this.getClass());
	
	
	@Bean
    public Sampler alwaysSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }
	RestTemplate restTemplate = new RestTemplate();
	
	@GetMapping(value = "/microservice2")
	public String method2() {
		LOG.info("Inside method2");
		String baseUrl = "http://localhost:8082/third/microservice3";
		String response = (String) restTemplate.exchange(baseUrl, HttpMethod.GET, null, String.class).getBody();
		LOG.info("The response received by method2 is " + response);
		return response;
	}
	
}
