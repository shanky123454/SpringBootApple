package in.com.employee;

public class B {

	public A a1;
	
	static {
		System.out.println("B static block method()");
	}
	public B()
	{
		System.out.println(" creating object of class B using zero-param constructor");
	}
	
	
	public A getA1() {
		return a1;
	}

	public void setA1(A a1) {
		this.a1 = a1;
	}


	@Override
	public String toString() {
		return "B [a1=" + a1 + "]";
	}
	
}
