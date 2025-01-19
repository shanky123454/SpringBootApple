package in.com.model;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "Payment-Details")
@DiscriminatorColumn(name = "Payment_Mode" ,discriminatorType = DiscriminatorType.STRING)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Payment implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public int payment_id;
	public float amount;

	public Payment() {
		System.out.println("inside payment class");
	}

	
	public int getPayment_id() {
		return payment_id;
	}
	
	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Payment [payment_id=" + payment_id + ", amount=" + amount + "]";
	}
	
	
}


