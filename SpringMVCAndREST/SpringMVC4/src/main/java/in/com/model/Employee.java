package in.com.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

	private Integer eno;
	private String ename="sachin";
	private String desg;
	private Double salary;


}
