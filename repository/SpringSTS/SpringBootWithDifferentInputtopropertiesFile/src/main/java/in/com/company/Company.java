package in.com.company;

import org.springframework.stereotype.Component;

@Component(value = "company")
public class Company {
	
	static {
		System.out.println("Company.static()");
	}

	public Company()
	{
		System.out.println("Company.Company()");
	}
	
	private String type;
	private String location;
	private String name;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Company [type=" + type + ", location=" + location + ", name=" + name + "]";
	}

}
