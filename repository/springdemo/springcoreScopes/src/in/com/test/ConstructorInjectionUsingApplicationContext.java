package in.com.test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.com.employee.Address;
import in.com.employee.Employee;


public class ConstructorInjectionUsingApplicationContext {

	public static void main(String[] args) throws Exception {
		
		//ClassPathResource fres = new ClassPathResource("in\\com\\cfg\\applicationContext.xml"); // ERROR
       ApplicationContext factory = new ClassPathXmlApplicationContext("in\\com\\cfg\\applicationContext.xml");
    
       System.in.read();
		Object obj =factory.getBean("emp",Employee.class);
		Employee e = (Employee)obj;
		Employee e1 = (Employee)factory.getBean("emp", Employee.class);
		
		System.out.println(e.hashCode());
		System.out.println(e1.hashCode());
		
		System.out.println("**************************************");
		
		Address a1 = (Address)factory.getBean("add",Address.class);
		System.out.println(a1.hashCode());
		
		Address a2 = (Address)factory.getBean("add",Address.class);
		System.out.println(a2.hashCode());
	

	}

}
