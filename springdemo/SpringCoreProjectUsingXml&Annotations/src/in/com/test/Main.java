package in.com.test;

import java.util.Properties;
import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.zaxxer.hikari.HikariDataSource;
import in.com.cfg.AppsConfig;
import in.com.controller.CustomerController;
import in.com.vo.CustomerVo;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc  = new Scanner(System.in);
		
		System.out.println("enter the name of the customer");
		String name = sc.nextLine();
		
		System.out.println("enter the address of the customer");
		String addr = sc.nextLine();
		
		System.out.println("enter the pamt");
		String pamt= sc.nextLine();
		
		System.out.println("enter the rate");
		String rate = sc.nextLine();
		
		System.out.println("enter the time");
		String time = sc.nextLine();
		
		CustomerVo vo = new CustomerVo();
		vo.setCaddress(addr);
		vo.setCname(name);
		vo.setPamt(pamt);
		vo.setRate(rate);
		vo.setTime(time); 
		
		//ApplicationContext factory = new ClassPathXmlApplicationContext("in\\com\\cfg\\applicationContext.xml");
		ApplicationContext factory = new AnnotationConfigApplicationContext(AppsConfig.class);
		Object obj  = factory.getBean("custcontroller",CustomerController.class);
		CustomerController customercontroller = (CustomerController)obj;
	
		try {
			String result = customercontroller.processCustomer(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		sc.close();
	}
	DriverManagerDataSource dmd = new DriverManagerDataSource();
	HikariDataSource hds = new HikariDataSource();
	Properties p = new Properties();
}
