package in.com.CourierImplClass;

import java.time.LocalDateTime;
import java.util.Arrays;

import java.util.Random;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cglib.core.Local;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import in.com.courier.CourierCompany;

@Component(value = "fpkt2")
@Scope(value = "singleton")
public class Flipkart2 {

	@Autowired(required = true)
	@Qualifier(value = "dtdc")
	private CourierCompany couriercompany;
	
	//@Value(value = "20.0f")
	@Value(value = "${fpkt.discount}")
	private float discount;
	
	@Autowired(required = true)
	private LocalDateTime dt;
	
	static{
		System.out.println("flipkart2 .class file is loading");
	}
	
	public Flipkart2() {
	   System.out.println("creating flipkart2 object using 0-param constructor");
	}

	
	public Flipkart2( CourierCompany couriercompany, float discount, LocalDateTime dt)
	{
		this.dt=dt;
		this.couriercompany=couriercompany;
		this.discount=discount;
		System.out.println("creating flipkart object using 2-param constructor");
		System.out.println(this);
	}
	
	public LocalDateTime getDt() {
		return dt;
	}

	public void setDt(LocalDateTime dt) {
		this.dt = dt;
	}

	public CourierCompany getCouriercompany() {
		return couriercompany;
	}
	

	public void setCouriercompany(CourierCompany couriercompany) {
		this.couriercompany = couriercompany;
		System.out.println("Flipkart.setCouriercompany()");
		System.out.println(this);
	}

	public float getDiscount() {
		return discount;
	}

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
				"having billamount of " + billamt +" "+ "=====>>"+ result+ " " +
		         "on date" + dt;
	}


	@Override
	public String toString() {
		return "Flipkart2 [couriercompany=" + couriercompany + ", discount=" + discount + ", dt=" + dt + "]";
	}

	

}
