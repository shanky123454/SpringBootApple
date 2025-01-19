package in.com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import in.com.CourierImplClass.Flipkart2;
import in.com.cfg.Main;

public class TestappUsingBeanFactory {

     public static void main(String[] args) {
		
	
	ApplicationContext factory = new AnnotationConfigApplicationContext(Main.class);
	Object obj = factory.getBean("fpkt2",Flipkart2.class);
	Flipkart2 fkt= (Flipkart2)obj;
	
	String res = fkt.doShopping(new String[] {"samsung","one-plus"}, new float[] { 2345.66f,5678.77f});
	System.out.println(res);
}
}
