package in.com.bo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Document(value = "CustomerBo")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class CustomerBo {
	
	@Id
	public String id;
	
	@NonNull
	public Integer cid;
	
	@NonNull
	public String cname;
	
	@NonNull
	public String[] caddress;
	
	@NonNull
	public Long[] cphone;

}
