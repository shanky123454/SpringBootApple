package in.com.employee;

import java.util.Properties;

public class student {

	public Properties course;
    
	static {
		System.out.println("student.static block method()");
	}
	public student()
	{
		System.out.println("using zero-param constructor");
	}
	public Properties getCourse() {
		return course;
	}
	public void setCourse(Properties course) {
		this.course = course;
	}
	@Override
	public String toString() {
		return "student [course=" + course + "]";
	}

	
}
