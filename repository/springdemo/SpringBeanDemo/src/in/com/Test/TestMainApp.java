package in.com.Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.com.Main.AppConfig;
import in.com.service.service;

public class TestMainApp {

	public static void main(String[] args) {
	
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		Object obj =context.getBean("service",service.class);
		
		
		service s = (service)obj;
		
   String result =s.checkVotingEligibility();
		System.out.println(result);
		s.myDestroy();
	}

}
