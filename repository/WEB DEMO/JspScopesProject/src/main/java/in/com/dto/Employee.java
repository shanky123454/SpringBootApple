package in.com.dto;

public class Employee {
	public int id;
	 public String name;
	 public int age;
	 public String address;
	 public int bsalary;
	 public float gsalary;
	 public float nsalary;
	 
   
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getBsalary() {
		return bsalary;
	}
	public void setBsalary(int bsalary) {
		this.bsalary = bsalary;
	}
	public float getGsalary() {
		return gsalary;
	}
	public void setGsalary(float gsalary) {
		this.gsalary = gsalary;
	}
	public float getNsalary() {
		return nsalary;
	}
	public void setNsalary(float nsalary) {
		this.nsalary = nsalary;
	}
	
	public String toString()
	{
		return id+""+name+""+age+""+address+""+bsalary+""+gsalary+""+nsalary;
	}
	 
	
}
