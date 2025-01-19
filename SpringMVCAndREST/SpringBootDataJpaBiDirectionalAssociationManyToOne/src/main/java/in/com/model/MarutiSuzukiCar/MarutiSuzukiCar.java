package in.com.model.MarutiSuzukiCar;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import in.com.model.person.Customer;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
@Table(name = "MarutiSuzukiCarrrr")
@Component
public class MarutiSuzukiCar {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long carNo;
	
	@NonNull
	private String color ;
	@NonNull
	private LocalDateTime mfgYear;

	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "cust_id",referencedColumnName = "pid")
	public Customer person;

	@Override
	public String toString() {
		return "MarutiSuzukiCar [carNo=" + carNo + ", color=" + color + ", mfgYear=" + mfgYear + "]";
	}

	}


