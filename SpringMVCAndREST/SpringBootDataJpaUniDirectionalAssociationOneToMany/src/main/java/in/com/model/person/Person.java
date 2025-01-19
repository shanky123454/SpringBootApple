package in.com.model.person;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import in.com.model.phone.PhoneNumbers;
import jakarta.annotation.Nonnull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
@Table(name = "personUni")
@Component
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer pid;
	
	@Nonnull
	public String pname;
	
	@Nonnull
	public String paddress;
	
 // FOR ONE TO MANY UNIDIRECTION 	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "personId",referencedColumnName = "pid")
	public Set<PhoneNumbers> numbers;


	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", paddress=" + paddress ;
	}


	

}