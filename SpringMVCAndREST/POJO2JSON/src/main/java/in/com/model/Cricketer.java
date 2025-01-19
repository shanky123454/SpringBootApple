package in.com.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cricketer {

	public String name;
	public int id;
	public String country;
	public Float avg;
}
