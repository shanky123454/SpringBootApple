package in.com.CourierImplClass;

import in.com.courier.CourierCompany;

public class FirstFlight implements CourierCompany {
	
	static {
		System.out.println("inside .class of FirstFlight");
	}

	public FirstFlight()
	{
		System.out.println("inside 0-param constructor");
	}

	@Override
	public String deliver(int oid) {
		return "delivery by FirstFlight is assigned with order id :" +oid;

	}

}
