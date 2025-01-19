package in.com.employee;

public class Address {

	public String state;
	public int pincode;
	public String city;
	
	static {
		System.out.println("Address.static method()");
	}
	
	public Address()
	{
		System.out.println("address class using zero-param constructor");
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Address [state=" + state + ", pincode=" + pincode + ", city=" + city + "]";
	}
	
}
