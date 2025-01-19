
package in.com;

import java.util.List;
import java.util.ListIterator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import in.com.component.Employee;
import in.com.dao.IDaoImplClass;

@SpringBootApplication
public class SpringBootProject1Application {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SpringBootProject1Application.class, args);
	IDaoImplClass dao  = applicationContext.getBean("dao", IDaoImplClass.class);
   List<Employee> emp =  dao.getEmployeeDetails();
   ListIterator< Employee> le = emp.listIterator();
   while(le.hasNext())
   {
	   System.out.println(le.next());
	 
   }
		 
	}

}
