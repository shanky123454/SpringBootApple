package in.com.service;

import org.springframework.beans.BeanUtils;
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
	public CustomerDto calculateSimpleInterest(CustomerDto dto) {
		float interestamt =0.f;
		
		interestamt= (dto.getPamt()*dto.getRate()*dto.getTime());
		
		CustomerBo bo = new CustomerBo();
		bo.setCaddress(dto.getCustomerAddress());
		bo.setCname(dto.getCustomerName());
		bo.setPamt(dto.getPamt());
		bo.setRate(dto.getRate());
		bo.setTime(dto.getTime());
		bo.setIntersetamount(interestamt);
		
		
		CustomerBo result= daointerface.save(bo);
		CustomerDto listdto= new CustomerDto();
//		listdto.setCustomerAddress(result.getCaddress());
//		listdto.setCustomerName(result.getCname());
//		listdto.setPamt(result.getPamt());
//		listdto.setRate(result.getRate());
//		listdto.setTime(result.getTime());
//		listdto.setIntersetamount(result.getIntersetamount());
		
		BeanUtils.copyProperties(result, listdto);
		System.out.println(listdto);
		
		return listdto;
	}

}
