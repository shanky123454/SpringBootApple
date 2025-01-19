package in.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.com.Ipurchase.IpurchaseImpl;

@SpringBootApplication
public class SpringMailApplication {

	public static void main(String[] args) throws Exception {
	ApplicationContext applicationContext = SpringApplication.run(SpringMailApplication.class, args);
	IpurchaseImpl impl = applicationContext.getBean(IpurchaseImpl.class);
	
String msg =impl.purchase(new String[] {"YAMAHA","BMW"}, new double[] {156777.45,56789.44},
			new String[] {"rshashank163@gmail.com","rshashank164@gmail.com"});
System.out.println(msg);


((ConfigurableApplicationContext) applicationContext).close();

	
	}

}
