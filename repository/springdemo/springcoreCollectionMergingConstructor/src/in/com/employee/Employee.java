package in.com.employee;

import java.util.Arrays;

public class Employee {

	public String[] courses;
    
	static {
		System.out.println("Employee.static block method()");
	}

	public Employee(String[] courses) {
		this.courses = courses;
		System.out.println("Employee.Employee()");
	}

	public String[] getCourses() {
		return courses;
	}

	@Override
	public String toString() {
		return "Employee [courses=" + Arrays.toString(courses) + "]";
	}
	
}
