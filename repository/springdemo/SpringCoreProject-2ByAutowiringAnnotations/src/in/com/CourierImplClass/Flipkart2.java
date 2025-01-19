package in.com.CourierImplClass;

import java.util.Arrays;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import in.com.courier.CourierCompany;

public class Flipkart2 {


	private CourierCompany couriercompany;
	

	private float discount;
	
	static{
		System.out.println("flipkart2 .class file is loading");
	}
	
	public Flipkart2() {
	   System.out.println("creating flipkart2 object using 0-param constructor");
	}

	
	public Flipkart2( CourierCompany couriercompany, float discount)
	{
		this.couriercompany=couriercompany;
		this.discount=discount;
		System.out.println("creating flipkart object using 2-param constructor");
		System.out.println(this);
	}

	public CourierCompany getCouriercompany() {
		return couriercompany;
	}
	
	@Autowired
	@Qualifier(value = "dtdc")
	public void setCouriercompany(CourierCompany couriercompany) {
		this.couriercompany = couriercompany;
		System.out.println("Flipkart.setCouriercompany()");
		System.out.println(this);
	}

	public float getDiscount() {
		return discount;
	}

	@Autowired
	@Required
	@Value(value = "22.33")
	public void setDiscount(float discount) {
		this.discount = discount;
		System.out.println("Flipkart.setDiscount()");
		System.out.println(this);
	}
	
	// business logic

	public String doShopping(String[] products, float[] prices) {
		System.out.println("flipkart.doShopping");
		System.out.println(couriercompany.getClass().getName());
		System.out.println();
		System.out.println("discount amt is:" + discount);
		
		float billamt=0.0f;
		int oid=0;
		Random random =null;
         random=new Random();

		
		for (float float1 : prices) {
			billamt=billamt+float1;
		}
		billamt=billamt-discount;
		oid=random.nextInt(1000);
		
		String result =couriercompany.deliver(oid);
		return Arrays.toString(products)+" are purchased having prices" + Arrays.toString(prices)+
				"having billamount of " + billamt +" "+ "=====>>"+ result;
	}

	@Override
	public String toString() {
		return "Flipkart [couriercompany=" + couriercompany + ", discount=" + discount + "]";
	}

}
