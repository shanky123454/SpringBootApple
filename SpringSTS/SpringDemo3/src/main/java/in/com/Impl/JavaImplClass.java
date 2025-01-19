package in.com.Impl;

import org.springframework.stereotype.Component;

import in.com.Istudent.ICourse;

@Component
public class JavaImplClass implements ICourse {
	
	static {
		System.out.println("JavaImplClass.static method()");
	}

	public JavaImplClass()
	{
		System.out.println("JavaImplClass.javaImplClass()");
	}
	@Override
	public String course() {
		System.out.println("JavaImplClass.course()");
		return "java , springboot......";
	}

	@Override
	public float price() {
		return 5555.5f;
	}

}
