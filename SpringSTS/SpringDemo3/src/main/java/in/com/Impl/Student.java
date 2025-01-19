package in.com.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.com.Istudent.ICourse;

@Component(value = "std")
public class Student {
	
	static {
		System.out.println("Student.static method()");
	}

	public Student()
	{
		System.out.println("Student.Student()");
	}
	
	@Autowired
	public ICourse iCourse;
	
	public String getDetails()
	{
		return "student registered in " +" " + iCourse.course()+" "+ " with amount" +" " +iCourse.price();
	}
}
