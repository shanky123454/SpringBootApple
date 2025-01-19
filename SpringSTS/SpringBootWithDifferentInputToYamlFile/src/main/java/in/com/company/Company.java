package in.com.company;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component(value = "company")
//@PropertySource(value = "./application.yml")
@ConfigurationProperties(value = "emp.info.company")
public class Company {
	
	static {
		System.out.println("Company.static()");
	}

	public Company()
	{
		System.out.println("Company.Company()");
	}
	
	//@Value("${emp.info.company.type}")
	private String type;
	
	//@Value("${emp.info.company.location}")
	private String location;
	
	//@Value("${emp.info.company.name}")
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
