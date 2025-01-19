package in.com.model.person;

import org.springframework.stereotype.Component;
import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "CustomerrrrrUniii")
@Component
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer pid;
	
	@Nonnull
	public String pname;
	
	@Nonnull
	public String paddress;
	
	// UNI DIRECTIONAL ONE TO MANY MAPPING 
//	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
//	public List<MarutiSuzukiCar> car;


	@Override
	public String toString() {
		return "customer [pid=" + pid + ", pname=" + pname + ", paddress=" + paddress ;
	}

}
