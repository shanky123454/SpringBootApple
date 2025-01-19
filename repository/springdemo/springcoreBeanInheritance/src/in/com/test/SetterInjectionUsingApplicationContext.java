package in.com.test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;


import in.com.employee.Employee;


public class SetterInjectionUsingApplicationContext {

	public static void main(String[] args) {
		
		//ClassPathResource fres = new ClassPathResource("in\\com\\cfg\\applicationContext.xml"); // ERROR
       ApplicationContext factory = new ClassPathXmlApplicationContext("in\\com\\cfg\\applicationContext.xml");
       
		Object obj =factory.getBean("emp1",Employee.class);
		Employee e = (Employee)obj;
		System.out.println(e);
		
		Object obj1 =factory.getBean("emp2",Employee.class);
		Employee e1 = (Employee)obj1;
		System.out.println(e1);
	

	}

}
