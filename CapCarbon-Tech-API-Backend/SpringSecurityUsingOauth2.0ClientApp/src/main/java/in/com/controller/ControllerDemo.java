package in.com.controller;
  
import java.io.IOException;
import java.util.Arrays;

import javax.websocket.server.PathParam;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


@Controller
public class ControllerDemo {

	
	  @GetMapping(value = "/getEmployees") public String getEmployeeInfo() { return
	  "getEmployees"; }
	 
	 
	 @GetMapping(value = "/showEmployees")
	    public String showEmployeeInfo(@PathParam(value = "code")  String code)
	    		throws JsonProcessingException, IOException{
	        System.out.println(code);

	        String credentials = "redbus:redbus@123";	        
			String encodedCredentials = new String(Base64.encodeBase64(credentials.getBytes()));

	        ResponseEntity<String> entity = null;
	        
	        RestTemplate restTemplate = new RestTemplate();
	        
	        HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			headers.add("Authorization", "Basic " + encodedCredentials);
	        
			HttpEntity<String> httpEntity = new HttpEntity<String>(headers);
			
	        
	        String url = "http://localhost:8084/oauth/token" ;
	        url += "?code=" + code;
	        url += "&grant_type=" + "authorization_code";
	        
			url += "&redirect_uri=http://localhost:8090/showEmployees";

	        
	        entity=   restTemplate.exchange(url, HttpMethod.POST,httpEntity,String.class);
	        	System.out.println("heklooooooooo");
	        System.out.println(entity.getBody());
	        
	     // Get the Access Token From the recieved JSON response
	        
			ObjectMapper mapper = new ObjectMapper();
			JsonNode node = mapper.readTree(entity.getBody());
			String token = node.path("access_token").asText();
			
			String url1 = "http://localhost:8084/demo/details";
			

			// Use the access token for authentication
			
			HttpHeaders headers1 = new HttpHeaders();
			headers1.add("Authorization", "Bearer " + token);
			HttpEntity<String> entity1 = new HttpEntity<>(headers1);
			ResponseEntity<String> res = restTemplate.exchange(url1, HttpMethod.GET, entity1, String.class);
			System.out.println(res.getBody());
	        
	        		return "welcome";
	    }
	 
}
