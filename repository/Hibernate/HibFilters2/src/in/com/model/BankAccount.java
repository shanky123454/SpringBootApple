package in.com.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@DynamicInsert(value = true)
@FilterDef(name="filter_bank_account_status", parameters = {
		@ParamDef(type = "string", name = "acctype1"),
		@ParamDef(type = "string", name = "acctype2")
})

@Filter(name = "filter_bank_account_status",condition = "accttype NOT IN(:acctype1,:acctype2)")
@SQLDelete(sql = "UPDATE BankAccount SET accttype='closed' WHERE Accno=?")
@Where(clause = "accttype not in ('closed','blocked')")
public class BankAccount  implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	public long Accno;
	
	public String accholdername;
	
	public String accttype;
	
	public float balance;
	
	public String address;
	
	public BankAccount()
	{
		System.out.println("inside BankAccount.java");
	}
	
	public long getAccno() {
		return Accno;
	}

	public void setAccno(long accno) {
		Accno = accno;
	}

	public String getAccholdername() {
		return accholdername;
	}

	public void setAccholdername(String accholdername) {
		this.accholdername = accholdername;
	}

	public String getAccttype() {
		return accttype;
	}

	public void setAccttype(String accttype) {
		this.accttype = accttype;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String toString() {
		 return Accno+" " + accholdername+" " +accttype +" "+ balance+" "+ address;
	}


}
