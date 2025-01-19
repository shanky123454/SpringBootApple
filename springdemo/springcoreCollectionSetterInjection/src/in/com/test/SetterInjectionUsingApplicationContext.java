package in.com.test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;


import in.com.employee.Employee;
import in.com.employee.Icc;
import in.com.employee.Movie;
import in.com.employee.Student;
import in.com.employee.Teams;


public class SetterInjectionUsingApplicationContext {

	public static void main(String[] args) {
		
		//ClassPathResource fres = new ClassPathResource("in\\com\\cfg\\applicationContext.xml"); // ERROR
       ApplicationContext factory = new ClassPathXmlApplicationContext("in\\com\\cfg\\applicationContext.xml");
       
		Object obj =factory.getBean("marks",Employee.class);
		Employee e = (Employee)obj;
		System.out.println(e);
	
		Object obj1 =factory.getBean("stdCourse",Student.class);
		Student s = (Student)obj1;
		System.out.println(s);
		
		Object obj2 =factory.getBean("team",Teams.class);
		Teams t = (Teams)obj2;
		System.out.println(t);
		
		Object obj3 =factory.getBean("movie",Movie.class);
		Movie m = (Movie)obj3;
		System.out.println(m);
		
		
		Object obj4 =factory.getBean("players",Icc.class);
		Icc i = (Icc)obj4;
		System.out.println(i);
	}

}
