package in.com.CourierImplClass;

import org.springframework.stereotype.Component;

import in.com.courier.CourierCompany;


public class BlueDart implements CourierCompany {
	
	static {
		System.out.println("inside .class of bluedart");
	}

	public BlueDart()
	{
		System.out.println("inside 0-param constructor");
	}

	@Override
	public String deliver(int oid) {
		return "delivery by BlueDart is assigned with order id :" +oid;

	}

}
