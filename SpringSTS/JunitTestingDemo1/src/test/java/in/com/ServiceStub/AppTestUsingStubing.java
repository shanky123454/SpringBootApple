package in.com.ServiceStub;

import java.util.Arrays;
import java.util.List;

import in.com.Iservice.Iservice;


public class AppTestUsingStubing implements Iservice
{

	@Override
	public List<String> retrieveTodos(String user) {
		return Arrays.asList("Learn Spring MVC", "Learn Spring",
				"Learn to Dance");
	}
	
}
