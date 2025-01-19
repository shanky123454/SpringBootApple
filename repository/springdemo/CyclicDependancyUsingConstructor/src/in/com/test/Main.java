package in.com.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import in.com.employee.A;
import in.com.employee.B;

public class Main {

	public static void main(String[] args) {
		
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("in/com/cfg/applicationContext.xml");
		Object obj =factory.getBean("a",A.class);
//		A aobj = (A)obj;
//		System.out.println(aobj);
		
		Object obj1 =factory.getBean("b",B.class);
//		B bobj = (B)obj1;
//	     System.out.println(bobj);
	}

}
