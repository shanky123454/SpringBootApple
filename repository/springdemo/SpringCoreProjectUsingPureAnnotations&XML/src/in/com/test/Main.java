package in.com.test;

import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import in.com.cfg.AppConfig;
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
		
		ApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);
		Object obj  = factory.getBean("controller",CustomerController.class);
		CustomerController customercontroller = (CustomerController)obj;
	
		try {
			String result = customercontroller.processCustomer(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		sc.close();
	}

}
