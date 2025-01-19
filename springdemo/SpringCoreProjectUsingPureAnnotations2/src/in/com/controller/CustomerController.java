package in.com.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import in.com.dto.CustomerDto;
import in.com.service.CustomerServiceInterface;
import in.com.vo.CustomerVo;

@Component(value = "controller")
public class CustomerController {
	
	@Autowired
	private CustomerServiceInterface customerserviceinterface;
	
	static {
		System.out.println("CustomerController.enclosing_method()");
	}
	
	public CustomerController(CustomerServiceInterface customerserviceinterface)
	{
		this.customerserviceinterface=customerserviceinterface;
		System.out.println("customercontroller object is created using constructor");
	}
	
	public CustomerVo processCustomer(CustomerVo vo)
	{
		CustomerDto dto = new CustomerDto();
		dto.setCustomerAddress((vo.getCaddress()));
		dto.setCustomerName(vo.getCname());
		dto.setPamt(Float.parseFloat(vo.getPamt()));
		dto.setRate(Float.parseFloat(vo.getRate()));
		dto.setTime(Float.parseFloat(vo.getTime()));
		
		CustomerDto result =customerserviceinterface.calculateSimpleInterest(dto);
		CustomerVo listvo = new CustomerVo();
//		listvo.setCaddress(result.getCustomerAddress());
//		listvo.setCname(result.getCustomerName());
//		listvo.setPamt(Float.toString(result.getPamt()));
//		listvo.setRate(Float.toString(result.getRate()));
//		listvo.setTime(Float.toString(result.getRate()));
//		listvo.setIntersetamount(Float.toString(result.getIntersetamount()));

		
		BeanUtils.copyProperties(result, listvo);
		return listvo;
		
		
	}

}
