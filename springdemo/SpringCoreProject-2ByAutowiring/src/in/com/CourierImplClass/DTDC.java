package in.com.CourierImplClass;

import in.com.courier.CourierCompany;

public class DTDC implements CourierCompany {
	
	static {
		System.out.println("inside .class of dtdc");
	}

	public DTDC()
	{
		System.out.println("inside 0-param constructor");
	}
	@Override
	public String deliver(int oid) {
		return "delivery by dtdc is assigned with order id :" +oid;
		
	}

}
