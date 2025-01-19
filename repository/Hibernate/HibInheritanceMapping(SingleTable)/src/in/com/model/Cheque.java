package in.com.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue(value = "cheque")
public class Cheque extends Payment implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public Long cheque_no;
	public LocalDate expiryDate;
	public String chequeType;
	
	
	public Cheque() {
         System.out.println("inside Cheque class");
	}
	public Long getCheque_no() {
		return cheque_no;
	}
	public void setCheque_no(Long cheque_no) {
		this.cheque_no = cheque_no;
	}
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getChequeType() {
		return chequeType;
	}
	public void setChequeType(String chequeType) {
		this.chequeType = chequeType;
	}
	

	@Override
	public String toString() {
		return "Cheque [cheque_no=" + cheque_no + ", expiryDate=" + expiryDate + ", chequeType=" + chequeType + "]";
	}

}
