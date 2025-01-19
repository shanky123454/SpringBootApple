package in.com.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import org.hibernate.annotations.ListIndexBase;

@Entity
@Table(name = "Cricketer_Details")
public class Cricketer implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private Integer cid;
	private String name;
	private String address;
	
	public Cricketer() {
	
		System.out.println("inside cricketer class");
	}
	
	@ElementCollection
	@Column(name = "Friend_name")
	@CollectionTable(name = "Cri_FRE" ,joinColumns = @JoinColumn(name="CRI_ID" ,referencedColumnName = "cid"))
	@OrderColumn(name = "friend_no")
	@ListIndexBase(value = 1)
	
	public List<String> friends_name;
	
	@ElementCollection
	@Column(name = "phone_no")
	@CollectionTable(name = "CRI_PHO" , joinColumns = @JoinColumn(name="cri_id",referencedColumnName = "cid"))
	
	public Set<Long> mobile_phones ;

	
	@ElementCollection
	@CollectionTable(name = "cri_bank_acc",joinColumns = @JoinColumn(name="cri_id",referencedColumnName = "cid"))
	@MapKeyColumn(name = "Bank_name",length = 10)
	@Column(name = "Account_no")

	public Map<String,Long> account_no;

	public Integer getCid() {
		return cid;
	}


	public void setCid(Integer cid) {
		this.cid = cid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public List<String> getFriends_name() {
		return friends_name;
	}


	public void setFriends_name(List<String> friends_name) {
		this.friends_name = friends_name;
	}


	public Set<Long> getMobile_phones() {
		return mobile_phones;
	}


	public void setMobile_phones(Set<Long> mobile_phones) {
		this.mobile_phones = mobile_phones;
	}


	public Map<String, Long> getAccount_no() {
		return account_no;
	}


	public void setAccount_no(Map<String, Long> account_no) {
		this.account_no = account_no;
	}


	@Override
	public String toString() {
		return "Cricketer [cid=" + cid + ", name=" + name + ", address=" + address + ", friends_name=" + friends_name
				+ ", mobile_phones=" + mobile_phones + ", account_no=" + account_no + "]";
	}
	


	

}