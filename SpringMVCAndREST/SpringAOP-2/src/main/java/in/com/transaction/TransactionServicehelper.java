package in.com.transaction;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TransactionServicehelper {
	
	@Pointcut("execution(public * in.com.dao.*.*(..))")
	public void p1(){}
	
	@Before("p1()")
	public void beginTransaction() {
		System.out.println("transaction begins");
	}

	@AfterReturning(value = "p1()",returning = "obj")
	public void afterReturning(Object obj) {
		System.out.println("id is :" + obj);
		System.out.println("returned from business logic");
	}
	
	@AfterThrowing(value ="p1()",throwing = "obj")
	public void afterThrowing(Throwable obj) {
		System.out.println(obj.getMessage());
		System.out.println("after exception occurs");
	}
	
	@After("p1()")
	public void getRegister() {
		System.out.println("person email got registered");
	}
	
	@Around("p1()")
	public Object aroundTest(ProceedingJoinPoint joinPoint) {
		Object obj=null;
		System.out.println("before business method");
		try {
			obj =joinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("after business method logic");
		return  obj;
		
	}
	
 
}
