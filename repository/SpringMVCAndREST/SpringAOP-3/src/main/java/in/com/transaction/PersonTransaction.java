package in.com.transaction;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PersonTransaction {
	
	@Pointcut("@annotation(in.com.mytransaction.MyTransaction)")
	public void p() {}
	
	@Before("p()")
	public void beginTransaction() {
		System.out.println("beginTransaction()");
	}

	@AfterReturning(value = "p()",returning = "obj")
	public void commitTransaction(Object obj) {
		System.out.println("Id is :" +obj);
		System.out.println("commitTransaction()");
	}
}
