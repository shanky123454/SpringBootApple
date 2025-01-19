package in.com.chachi;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import in.com.model.Cricketer;

public class App 
{
    public static void main( String[] args )
    {
      ObjectMapper mapper = new ObjectMapper();
      Cricketer cricketer = new Cricketer();
      cricketer=getCricketer();
      System.out.println("in java format:" + cricketer);
      
	try {
		 String json_format = mapper.writeValueAsString(cricketer);
		  System.out.println(json_format);
	} catch (JsonProcessingException e) {
		e.printStackTrace();
	}
    
      
      try {
		mapper.writeValue(new File("Data/info.json"),cricketer);
	} catch (IOException e) {
		e.printStackTrace();
	}
    }
    public static Cricketer getCricketer() {
    	Cricketer cricketer = new Cricketer();
    	cricketer.setAvg((float) 23.545);
    	cricketer.setId(10);
    	cricketer.setName("sachin");
    	cricketer.setCountry("india");
    	return cricketer;
    }
}
