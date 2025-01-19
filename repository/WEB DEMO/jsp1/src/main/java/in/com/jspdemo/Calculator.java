package in.com.jspdemo;

public class Calculator {


	public int a =20;
	public int b =20;
	
	static {
		System.out.println("claculator .class file is loaded");
	}
	
	public Calculator()
	{
		System.out.println("calculator class object is created");
	}
	
	public int add()
	{
		return a+b;
	}
	public int mul()
	{
		return a*b;
	}
	
}
