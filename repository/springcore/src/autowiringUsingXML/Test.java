package autowiringUsingXML;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {   
	

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Autowiring.xml");
		Emp e1 = context.getBean("emp", Emp.class);
		System.out.println(e1);
	}

}


