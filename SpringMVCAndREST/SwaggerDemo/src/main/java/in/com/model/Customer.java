package in.com.model;

import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	
	public int id;
	public String name;
	public float price;

}
