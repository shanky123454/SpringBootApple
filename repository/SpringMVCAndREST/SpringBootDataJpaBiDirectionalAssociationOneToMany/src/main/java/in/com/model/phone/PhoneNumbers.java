package in.com.model.phone;

import org.springframework.stereotype.Component;

import in.com.model.person.Person;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "MTO_PhoneNumbers")
@Component
public class PhoneNumbers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long regNo;
	
	@NonNull
	private Long phoneNo;
	@NonNull
	private String provider;
	@NonNull
	private String type;

	@ManyToOne(targetEntity = Person.class,cascade = CascadeType.ALL)
	public Person person;

	@Override
	public String toString() {
		return "PhoneNumbers [regNo=" + regNo + ", phoneNo=" + phoneNo + ", provider=" + provider + ", type=" + type
			;
	}

}
