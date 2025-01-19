package in.com;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import in.com.controller.CustomerController;
import in.com.vo.CustomerVo;

@SpringBootApplication
public class SpringBootProject2Application {

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
		
	ApplicationContext factory =	SpringApplication.run(SpringBootProject2Application.class, args);
		
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
