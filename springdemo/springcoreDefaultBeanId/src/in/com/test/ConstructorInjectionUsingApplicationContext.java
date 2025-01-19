package in.com.test;
import java.util.Arrays;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import in.com.employee.Employee;

     
public class ConstructorInjectionUsingApplicationContext {

	public static void main(String[] args) throws Exception {
		
		//ClassPathResource fres = new ClassPathResource("in\\com\\cfg\\applicationContext.xml"); // ERROR
       ApplicationContext factory = new ClassPathXmlApplicationContext("in\\com\\cfg\\applicationContext.xml");
       System.out.println(Arrays.toString(factory.getBeanDefinitionNames()));
       System.in.read();
       
		Object obj =factory.getBean("in.com.employee.Employee#0",Employee.class);
		Employee e = (Employee)obj;
		System.out.println(e);
		
		Object obj1 =factory.getBean("in.com.employee.Employee#1",Employee.class);
		Employee e1 = (Employee)obj1;
		System.out.println(e1);
	

	}

}
