package in.com.employee;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import in.com.company.Company;

@Component("employee")
@ConfigurationProperties(prefix="emp.info")
//@PropertySource(value = "./application.yml")
public class Employee {
	
	static {
		System.out.println("Employee.static()");
	}
	
	public Employee()
	{
		System.out.println("Employee.Employee()");
	}
	//@Value("${emp.info.name}")
	private String name;
	
	//@Value("${emp.info.id}")
	private Integer id;
	
	//@Value("${emp.info.nick-names}")
	private String[] nickNames;
	
	//@Value("${emp.info.team-members}")
	private List<String> teamMembers;
	
	//@Value("${emp.info.phone-numbers}")
	private Set<Long> phoneNumbers;
	
	//@Value("${emp.info.id-details}")
	private Map<String, Object> idDetails;
	
	@Autowired
	public Company company;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String[] getNickNames() {
		return nickNames;
	}
	public void setNickNames(String[] nickNames) {
		this.nickNames = nickNames;
	}
	public List<String> getTeamMembers() {
		return teamMembers;
	}
	public void setTeamMembers(List<String> teamMembers) {
		this.teamMembers = teamMembers;
	}
	public Set<Long> getPhoneNumbers() {
		return phoneNumbers;
	}
	public void setPhoneNumbers(Set<Long> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
	public Map<String, Object> getIdDetails() {
		return idDetails;
	}
	public void setIdDetails(Map<String, Object> idDetails) {
		this.idDetails = idDetails;
	}
	
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + ", nickNames=" + Arrays.toString(nickNames) + ", teamMembers="
				+ teamMembers + ", phoneNumbers=" + phoneNumbers + ", idDetails=" + idDetails + ", company=" + company
				+ "]";
	}

}
