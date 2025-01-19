package in.com.employee;

import java.util.Properties;

public class student {

	public Properties course;
    
	static {
		System.out.println("student.static block method()");
	}

	public student(Properties course) {
		this.course = course;
		System.out.println("student.student()");
	}

	public Properties getCourse() {
		return course;
	}

	@Override
	public String toString() {
		return "student [course=" + course + "]";
	}
	
}
