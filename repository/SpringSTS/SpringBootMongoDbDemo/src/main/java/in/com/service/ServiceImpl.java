package in.com.service;

import java.util.List;

import in.com.bo.CustomerBo;
import in.com.dto.CustomerDto;

public interface ServiceImpl {
	
	public List<CustomerBo> getCustomer();
	
	public void registerCustomer(CustomerDto customer);
	
	public List<CustomerDto> getByPhone(Long[] phone);
	
	public List<CustomerDto> getByCname(String... cname);
	
	public List<CustomerDto> getByCid(Integer... cname);

}
