package in.com.ineuron;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component( value = "Emp")
public class Emp {
	
	@Autowired
	public Samosa samosa;
	

	public String name;
	public String city;
  

	public Emp( String name, String city) {
		this.name = name;
		this.city = city;
	}

	@Override
	public String toString() {
		return "Emp [name=" + name + ", city=" + city + "]";
	}

	public String getName() {
		return name;
	}

	public String getCity() {
		return city;
	}

}
