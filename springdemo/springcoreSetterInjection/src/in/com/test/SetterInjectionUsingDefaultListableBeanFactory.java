package in.com.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

import in.com.employee.Employee;


public class SetterInjectionUsingDefaultListableBeanFactory {

	public static void main(String[] args) {
		
//	FileSystemResource fres = new FileSystemResource("src\\in\\com\\cfg\\applicationContext.xml");
//	ClassPathResource  cres = new ClassPathResource("in\\com\\cfg\\applicationContext.xml");

		
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("in\\com\\cfg\\applicationContext.xml");
		Object obj =factory.getBean("emp",Employee.class);
		Employee e = (Employee)obj;
		System.out.println(e);
	

	}

}
