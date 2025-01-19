package in.com.model.person;

import java.util.List;

import org.springframework.stereotype.Component;

import in.com.model.MarutiSuzukiCar.MarutiSuzukiCar;
import jakarta.annotation.Nonnull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "MTM_Customer")
@Component
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer pid;
	
	@Nonnull
	public String pname;
	
	@Nonnull
	public String paddress;
	
	
	@ManyToMany(targetEntity = MarutiSuzukiCar.class,fetch = FetchType.EAGER,
			cascade = CascadeType.ALL)
	public List<MarutiSuzukiCar> car;


	/*
	 * @Override public String toString() { return "Customer [pid=" + pid +
	 * ", pname=" + pname + ", paddress=" + paddress + ", car=" + car + "]"; }
	 */


	
	  @Override public String toString() { return "customer [pid=" + pid +
	  ", pname=" + pname + ", paddress=" + paddress ; }
	 

}
