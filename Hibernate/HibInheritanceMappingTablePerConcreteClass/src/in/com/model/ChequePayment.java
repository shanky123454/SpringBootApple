package in.com.model;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Cheque_payment_Concrete_Class")
//@DiscriminatorValue("CHEQUE")
//@PrimaryKeyJoinColumn(name = "Payment_Id", referencedColumnName = "pid")
public class ChequePayment extends Payment implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long chequeNo;
	private String chequeType;
	private LocalDate expriyDate;

	public Long getChequeNo() {
		return chequeNo;
	}

	public void setChequeNo(Long chequeNo) {
		this.chequeNo = chequeNo;
	}

	public String getChequeType() {
		return chequeType;
	}

	public void setChequeType(String chequeType) {
		this.chequeType = chequeType;
	}

	public LocalDate getExpriyDate() {
		return expriyDate;
	}

	public void setExpriyDate(LocalDate expriyDate) {
		this.expriyDate = expriyDate;
	}

	@Override
	public String toString() {
		return "ChequePayment [chequeNo=" + chequeNo + ", chequeType=" + chequeType + ", expriyDate=" + expriyDate
				+ "]";
	}

}