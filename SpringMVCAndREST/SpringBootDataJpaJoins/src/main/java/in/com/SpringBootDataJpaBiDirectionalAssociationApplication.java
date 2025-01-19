package in.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import in.com.IserviceImpl.IServiceImpl;

@SpringBootApplication
public class SpringBootDataJpaBiDirectionalAssociationApplication {

	public static void main(String[] args) {
	ApplicationContext applicationContext =	 SpringApplication.run(SpringBootDataJpaBiDirectionalAssociationApplication.class, args);
IServiceImpl impl =	applicationContext.getBean(IServiceImpl.class);

impl.fetchDataByJoinsUsingCar().forEach(t->{
	for (Object obj : t) {
		System.out.println(obj);
	}
	System.out.println();
});

impl.fetchDataByJoinsUsingCustomer().forEach(t->{
	for(Object obj: t) {
		System.out.println(obj);
	}
	System.out.println();
});
	}
}
