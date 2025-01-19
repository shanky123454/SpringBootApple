package in.com.Impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import in.com.Istudent.ICourse;

@Component
@Primary
public class DotnetImplClass implements ICourse {
	
	static {
		System.out.println("DotnetImplClass.static method()");
	}

	public DotnetImplClass()
	{
		System.out.println("DotnetImplClass.DotnetImplClass()");
	}
	@Override
	public String course() {
		System.out.println("DotnetImplClass.course()");
		return "c# , asp.net......";
	}

	@Override
	public float price() {
		return 333.65f;
	}

}
