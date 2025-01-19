package in.com.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class CustomerDto {

	@NonNull
	public Integer cid;
	
	@NonNull
	public String cname;
	
	@NonNull
	public String[] caddress;
	
	@NonNull
	public Long[] cphone;

}
