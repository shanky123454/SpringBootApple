package in.com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import in.com.VO.EmployeeVO;
import in.com.controller.EmployeeController;


@SpringBootApplication
public class SpringBootProfileApplication {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ApplicationContext applicationContext =SpringApplication.run(SpringBootProfileApplication.class, args);
		
		System.out.println(applicationContext);
		
		System.out.println("no. of beans are :" + Arrays.toString(applicationContext.getBeanDefinitionNames()));
		
		System.out.println("enter the types of desgn");
		Integer count = sc.nextInt();
		
		String[] desg = new String[count];
		for(int i=0;i<count;++i)
		{
			System.out.println("enter the first desg you want");
			String desg1=sc.next();
			desg[i]=desg1;
		}
		
		EmployeeVO employeeVO = new EmployeeVO();
		   
		List<EmployeeVO> employeevo = new ArrayList<>();
		
		EmployeeController controller =  applicationContext.getBean("empController",EmployeeController.class);
		
		 employeevo =  controller.getEmpByDesg(desg);
		 
		 employeevo.forEach(System.out::println);
		
		}
	}


