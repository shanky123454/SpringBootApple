package in.com.response;

import in.com.request.PassangerInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketInfo {

	public String status;
	public Double price;
	public PassangerInfo info;
}
