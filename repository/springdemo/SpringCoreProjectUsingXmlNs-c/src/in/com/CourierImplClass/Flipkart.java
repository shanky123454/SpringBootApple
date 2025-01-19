package in.com.CourierImplClass;

import java.util.Arrays;
import java.util.Random;

import in.com.courier.CourierCompany;

public class Flipkart {

	private CourierCompany couriercompany;
	private float discount;
	
	static{
		System.out.println("flipkart .class file is loading");
	}

	public Flipkart(CourierCompany couriercompany, float discount) {
		this.couriercompany = couriercompany;
		this.discount = discount;
		System.out.println(this);
	}

	public CourierCompany getCouriercompany() {
		return couriercompany;
	}

	public void setCouriercompany(CourierCompany couriercompany) {
		this.couriercompany = couriercompany;
		System.out.println(this);
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
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


		
		for (float float1 : prices) {
			billamt=billamt+float1;
		}
		billamt=billamt-discount;
		random = new Random();
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