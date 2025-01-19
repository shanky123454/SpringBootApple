package in.com.ServiceImplClassStubTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import in.com.Iservice.Iservice;
import in.com.ServiceImplClass.ServiceImplClass;


public class ServiceClassImplUsingMock{

	
	@org.junit.Test
	public void Test()
	{
		Iservice iservice = mock(Iservice.class);
		List<String> todolist1 =Arrays.asList("shanky","shashank","adarsh");
		when(iservice.retrieveTodos("user")).thenReturn(todolist1);
		
	  ServiceImplClass serviceImplClass = new ServiceImplClass(iservice);
	List<String> resultlist = serviceImplClass.retrieveTodos("user");
	
		assertEquals(2, resultlist.size());
		
		 
//		verify(null);
//		verify(null, null);
//		Double d =Double.NaN;
//		System.out.println(d);
//		System.out.println(Math.sqrt(-5));
//		System.out.println(Integer.MAX_VALUE);
//		System.out.println(Integer.MAX_VALUE +1);
//		System.out.println(Integer.MIN_VALUE);
//		System.out.println(Integer.MIN_VALUE -1);

		//Integer i = Integer.NaN;
	//	BigDecimal
	}
	
	
	
	

}
