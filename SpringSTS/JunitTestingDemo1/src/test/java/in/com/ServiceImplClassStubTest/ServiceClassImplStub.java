package in.com.ServiceImplClassStubTest;

import static org.junit.Assert.assertEquals;

import java.util.List;

import in.com.Iservice.Iservice;
import in.com.ServiceImplClass.ServiceImplClass;
import in.com.ServiceStub.AppTestUsingStubing;


public class ServiceClassImplStub {

	
	@org.junit.Test
	public void Test()
	{
		Iservice iservice = new AppTestUsingStubing();
		ServiceImplClass serviceImplClass = new ServiceImplClass(iservice);
	List<String> resultlist = serviceImplClass.retrieveTodos("user");
	
		assertEquals(2, resultlist.size());
	}
	
	
	
	

}
