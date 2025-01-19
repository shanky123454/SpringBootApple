package in.com.CourierImplClass;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import in.com.courier.CourierCompany;

@Component(value = "dtdc")
//@Primary
//@Lazy(value = true)
@Scope(value = "prototype")
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
