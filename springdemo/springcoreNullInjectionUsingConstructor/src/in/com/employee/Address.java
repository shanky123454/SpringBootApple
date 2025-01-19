package in.com.employee;

public class Address {

	public String state;
	public int pincode;
	public String city;
	
	static {
		System.out.println("Address.static method()");
	}
	
	public Address(String state, int pincode, String city) {
		this.state = state;
		this.pincode = pincode;
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public int getPincode() {
		return pincode;
	}

	public String getCity() {
		return city;
	}

	@Override
	public String toString() {
		return "Address [state=" + state + ", pincode=" + pincode + ", city=" + city + "]";
	}
	
}
