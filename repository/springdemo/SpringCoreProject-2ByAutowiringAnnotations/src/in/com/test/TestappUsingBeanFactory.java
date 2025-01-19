package in.com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import in.com.CourierImplClass.Flipkart;
import in.com.CourierImplClass.Flipkart2;

public class TestappUsingBeanFactory {

     public static void main(String[] args) {
		
    	 
	ApplicationContext factory = new ClassPathXmlApplicationContext("in\\com\\cfg\\applicationContext.xml");
	Object obj = factory.getBean("fpkt",Flipkart.class);
	Flipkart fkt= (Flipkart)obj;
	
	String res = fkt.doShopping(new String[] {"samsung","one-plus"}, new float[] { 2345.66f,5678.77f});
	System.out.println(res);
	
//	ApplicationContext factory = new ClassPathXmlApplicationContext("in\\com\\cfg\\applicationContext.xml");
//	Object obj = factory.getBean("fpkt2",Flipkart2.class);
//	Flipkart2 fkt= (Flipkart2)obj;
//	
//	String res = fkt.doShopping(new String[] {"samsung","one-plus"}, new float[] { 2345.66f,5678.77f});
//	System.out.println(res);
}
}
