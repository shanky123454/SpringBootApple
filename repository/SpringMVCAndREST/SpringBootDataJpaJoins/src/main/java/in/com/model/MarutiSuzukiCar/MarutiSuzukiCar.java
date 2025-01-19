package in.com.model.MarutiSuzukiCar;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Component;

import in.com.model.person.Customer;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name = "OTM_MarutiSuzukiCar")
@Component
public class MarutiSuzukiCar {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long carNo;
	
	@NonNull
	private String color ;
	@NonNull
	private LocalDateTime mfgYear;

	@OneToMany(targetEntity = Customer.class,mappedBy = "car",fetch = FetchType.EAGER)
	public List<Customer> person;

	@Override
	public String toString() {
		return "MarutiSuzukiCar [carNo=" + carNo + ", color=" + color + ", mfgYear=" + mfgYear + "]";
	}

	}


