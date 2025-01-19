package in.com.employee;

public class A {

	public B b1;
	
	static {
		System.out.println("A.static method()");
	}
	
	public A() {
		System.out.println("A:: 0 param constructor");
	}
	
	public A(B b1)
	{
		this.b1=b1;
		System.out.println("A class using 1-param constructor");
	}
	
	public B getB1() {
		return b1;
	}

	public void setB1(B b1) {
		this.b1 = b1;
	}

	@Override
	public String toString() {
		return "A [b1=" + b1 + "]";
	}

}
