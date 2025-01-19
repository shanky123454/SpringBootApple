package in.com.employee;

import java.util.Arrays;

public class Employee {

	public String[] courses;
    
	static {
		System.out.println("Employee.static block method()");
	}
	public Employee()
	{
		System.out.println("using zero-param constructor");
	}
	public String[] getCourses() {
		return courses;
	}
	public void setCourses(String[] courses) {
		this.courses = courses;
	}
	@Override
	public String toString() {
		return "Employee [courses=" + Arrays.toString(courses) + "]";
	}
	
}
