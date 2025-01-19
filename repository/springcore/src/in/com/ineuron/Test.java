package in.com.ineuron;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test {   

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(JavaMain.class);
		Samosa e1 = context.getBean("samosa", Samosa.class);
		System.out.println(e1);
		e1.getprice();
		
		ApplicationContext context1 = new AnnotationConfigApplicationContext(JavaMain.class);
		Emp e2 = context1.getBean("Emp", Emp.class);
		System.out.println(e2);
	
	}
	//ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("xml file name");

}

