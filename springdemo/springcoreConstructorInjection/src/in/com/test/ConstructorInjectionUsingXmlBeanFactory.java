package in.com.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

import in.com.employee.Employee;


public class ConstructorInjectionUsingXmlBeanFactory {

	public static void main(String[] args) {
		
		//FileSystemResource fres = new FileSystemResource("src\\in\\com\\cfg\\applicationContext.xml");
		ClassPathResource  cres = new ClassPathResource("in\\com\\cfg\\applicationContext.xml");
		//XmlBeanFactory factory = new XmlBeanFactory(fres);
		XmlBeanFactory factory = new XmlBeanFactory(cres);
		Object obj =factory.getBean("emp",Employee.class);
		Employee e = (Employee)obj;
		System.out.println(e);
	

	}

}
