package in.com.test;
import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.ResourceBundleMessageSource;


public class SetterInjectionUsingApplicationContext {

	public static void main(String[] args) {
		
       ApplicationContext factory = new ClassPathXmlApplicationContext("in\\com\\cfg\\applicationContext.xml");
      	Locale l = new Locale("fr", "FR");
	Locale l1= new Locale("hi","IN");
	Locale l2 = new Locale("de","DE");
	String s =factory.getMessage("btn1.cap", null, l);
	String s2=factory.getMessage("btn1.cap", new String[] {"shashank"}, l1);
	System.out.println(s);
	System.out.println(s2);
	String s3 = factory.getMessage("btn1.cap", null, l2);
	System.out.println(s3);

	}

}
