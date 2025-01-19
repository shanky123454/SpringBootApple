package in.com.employee;

public class B {

	public A a1;
	
	static {
		System.out.println("B static block method()");
	}
	public B(A a1)
	{
		this.a1=a1;
		System.out.println(" creating object of class B using zero-param constructor");
	}
	
	@Override
	public String toString() {
		return "B [a1=" + a1 + "]";
	}
	
}
