package in.com.bo;
import java.io.Serializable;

import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@javax.persistence.Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "coronaaaaa")
public class CoronaVaccine implements Serializable {

	private static final long serialVersionUID = 1L;
	

	@javax.persistence.Id
	@javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	private Long regNo;

	@NonNull
	private String name;

	@NonNull
	private String company;

	@NonNull
	private String country;

	@NonNull
	private Double price;

	@NonNull
	private Integer requriedDoseCount;
	
}

