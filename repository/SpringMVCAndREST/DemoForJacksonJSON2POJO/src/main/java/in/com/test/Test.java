package in.com.test;

import java.io.File;
import com.fasterxml.jackson.databind.ObjectMapper;

import in.com.model.Customer;

public class Test {

	public static void main(String[] args) {
		
		ObjectMapper mapper = new ObjectMapper();
		try {
		Customer customer =	mapper.readValue(new File("data/info.json"),Customer.class);
		System.out.println(customer);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
