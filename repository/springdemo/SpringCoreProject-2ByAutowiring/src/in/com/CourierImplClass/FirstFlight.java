package in.com.CourierImplClass;

import in.com.courier.CourierCompany;

public class FirstFlight implements CourierCompany {
	
	static {
		System.out.println("inside .class of FirstFlight");
	}

	public FirstFlight()
	{
		System.out.println("FirstFlight.FirstFlight()");
	}

	@Override
	public String deliver(int oid) {
		return "delivery by FirstFlight is assigned with order id :" +oid;

	}

}
