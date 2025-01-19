package in.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.com.bo.CustomerBo;
import in.com.dao.CustomerDaoInterface;
import in.com.dto.CustomerDto;

@Service
public class CustomerServiceImplClass implements CustomerServiceInterface {
	
	@Autowired
	public CustomerDaoInterface daointerface;
	
	static {
		System.out.println("CustomerImplClass.enclosing_method()");
	}
	
	public CustomerServiceImplClass(CustomerDaoInterface daointerface) 
	{
		System.out.println("CustomerServiceImplClass.CustomerServiceImplClass()");
		this.daointerface=daointerface;
	}

	@Override
	public String calculateSimpleInterest(CustomerDto dto) {
		float interestamt =0.f;
		
		interestamt= (dto.getPamt()*dto.getRate()*dto.getTime());
		
		CustomerBo bo = new CustomerBo();
		bo.setCaddress(dto.getCustomerAddress());
		bo.setCname(dto.getCustomerName());
		bo.setPamt(dto.getPamt());
		bo.setRate(dto.getRate());
		bo.setTime(dto.getTime());
		bo.setIntersetamount(interestamt);
		
		
		int result= daointerface.save(bo);
		return result==0? "customer registration failed" : "successfully registerd" + interestamt;
	}

}
