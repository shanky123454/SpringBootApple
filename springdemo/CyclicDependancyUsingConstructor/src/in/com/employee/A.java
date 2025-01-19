package in.com.employee;

public class A {

	public B b1;
	
	static {
		System.out.println("A.static method()");
	}
	
	public A(B b1)
	{
		this.b1=b1;
		System.out.println("A class using zero-param constructor");
	}


	@Override
	public String toString() {
		return "A [b1=" + b1 + "]";
	}

}
