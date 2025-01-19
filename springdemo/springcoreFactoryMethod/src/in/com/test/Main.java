package in.com.test;
import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.com.employee.Print;




public class Main {

	public static void main(String[] args) throws Exception {
		
	   //ClassPathResource fres = new ClassPathResource("in\\com\\cfg\\applicationContext.xml"); // ERROR
       ApplicationContext factory = new ClassPathXmlApplicationContext("in\\com\\cfg\\applicationContext.xml");
       
      Print p1 = (Print) factory.getBean("add",Print.class);
      System.out.println(p1.hashCode());
      
      Print p2 = (Print) factory.getBean("add", Print.class);
      System.out.println(p2.hashCode());
       
       
       
       
	}

}
