package in.com.model.person;

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
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
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
@Table(name = "personOnetoOneMapsId")
@Component
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer pid;
	
	@Nonnull
	public String pname;
	
	@Nonnull
	public String paddress;
	
	@OneToOne(cascade = CascadeType.ALL,fetch =FetchType.EAGER)
    @MapsId
	public PhoneNumbers numbers;

Sh
	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", paddress=" + paddress ;
	}

	

}
