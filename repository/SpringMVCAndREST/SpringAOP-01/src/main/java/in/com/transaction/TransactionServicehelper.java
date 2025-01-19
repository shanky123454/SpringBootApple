package in.com.transaction;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TransactionServicehelper {
	
	@Pointcut("execution(public void in.com.dao.*.*())")
	public void p1() {}
	
	@Pointcut("execution(public int in.com.dao.*.*())")
	public void p2() {}
	
	@Pointcut("execution(public String in.com.dao.*.*(..))")
	public void p3() {}
	
	
//	@Pointcut("execution(public void in.com.dao.Employee.insertEmployee())")
//	public void p2() {}
//	
//	@Pointcut("p1() || p2()")
//	public void execute() {}
	
	@Pointcut("p1() || p2() || p3()")
	public void execute() {}
	
	  @Before("execute()") // JoinPoint
	//@Before("p1()") // JoinPoint
	public void beginTransaction()
	{
		System.out.println("transaction begins");
	}
	
	  @AfterReturning("execute()")
	//@AfterReturning("p1()")
	public void endTransaction()
	{
		System.out.println("transaction Commited");
	}
}
