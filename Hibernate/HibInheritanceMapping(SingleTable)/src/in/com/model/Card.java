package in.com.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue(value = "Card")
public class Card extends Payment implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public Long Card_no;
	public String card_type;
	public LocalDate expiry_date;
	public int cvv;
	
	
	public Card() {
	   System.out.println("inside card class");
	}
	public Long getCard_no() {
		return Card_no;
	}
	public void setCard_no(Long card_no) {
		Card_no = card_no;
	}
	public String getCard_type() {
		return card_type;
	}
	public void setCard_type(String card_type) {
		this.card_type = card_type;
	}
	public LocalDate getExpiry_date() {
		return expiry_date;
	}
	public void setExpiry_date(LocalDate expiry_date) {
		this.expiry_date = expiry_date;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	

	@Override
	public String toString() {
		return "Card [Card_no=" + Card_no + ", card_type=" + card_type + ", expiry_date=" + expiry_date + ", cvv=" + cvv
				+ "]";
	}

}
