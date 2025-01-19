package in.com.employee;

public class Address {

	public String state;
	public int pincode;
	public String city;
	
	static {
		System.out.println("Address.static method()");
	}
	
	public Address(int pincode,String state,String city)
	{
		this.state=state;
		this.pincode=pincode;
		this.city=city;
		System.out.println("address class using 3-param constructor");
	}

	@Override
	public String toString() {
		return "Address [state=" + state + ", pincode=" + pincode + ", city=" + city + "]";
	}
	
}
