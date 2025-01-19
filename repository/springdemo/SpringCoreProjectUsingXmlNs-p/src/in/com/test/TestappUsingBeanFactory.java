package in.com.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import in.com.CourierImplClass.Flipkart;

public class TestappUsingBeanFactory {

     public static void main(String[] args) {
		
	DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
	XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
	reader.loadBeanDefinitions("in\\com\\cfg\\applicationContext.xml");
	
	Object obj = factory.getBean("fpkt",Flipkart.class);
	Flipkart fkt= (Flipkart)obj;
	
	String res = fkt.doShopping(new String[] {"samsung","one-plus"}, new float[] { 2345.66f,5678.77f});
	System.out.println(res);
}
}
