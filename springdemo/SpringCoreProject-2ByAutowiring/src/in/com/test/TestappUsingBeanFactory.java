package in.com.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.com.CourierImplClass.Flipkart;

public class TestappUsingBeanFactory {

     public static void main(String[] args) {
    	 
    ApplicationContext context = new ClassPathXmlApplicationContext("in\\com\\cfg\\applicationContext.xml");

	Object obj = context.getBean("fpkt",Flipkart.class);
	Flipkart fkt= (Flipkart)obj;
	
	String res = fkt.doShopping(new String[] {"samsung","one-plus"}, new float[] { 2345.66f,5678.77f});
	System.out.println(res);
}
}
