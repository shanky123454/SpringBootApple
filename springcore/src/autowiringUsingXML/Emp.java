package autowiringUsingXML;

public class Emp {

	public Address address;

	public Address getAddress() {
		return address;
	}

//	public Emp(Address address) {
//		this.address = address;
//	}

	@Override
	public String toString() {
		return "emp [address=" + address + "]";
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
