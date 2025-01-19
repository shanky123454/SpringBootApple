package in.com.jspdemo;

public class Student {
	
	  public int id;
	  public String name;
	  public int age;
	  public String address;
	  
	  
	  static {
		  System.out.println("student .class file is loaded");
	  }
	  
	  public Student()
	  {
		  System.out.println("student class object got created");
	  }

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
	
	public String toString()
	{
		return id+" " +name+" " +age+" " +address;
	}
	
	  
} 
