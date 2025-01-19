package in.com.request;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassangerInfo {

	public int id;
	public String firstName;
	public String lastName;
	public LocalDateTime journeyDate;
	public String from;
	public String to;
	public String trainNo;
	
	
}
