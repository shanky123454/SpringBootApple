package in.com.controller;

import in.com.dto.CustomerDto;
import in.com.service.CustomerServiceInterface;
import in.com.vo.CustomerVo;

public class CustomerController {
	private CustomerServiceInterface customerserviceinterface;
	
	static {
		System.out.println("CustomerController.enclosing_method()");
	}
	
	public CustomerController(CustomerServiceInterface customerserviceinterface)
	{
		this.customerserviceinterface=customerserviceinterface;
		System.out.println("customercontroller object is created using constructor");
	}
	
	public String processCustomer(CustomerVo vo)
	{
		CustomerDto dto = new CustomerDto();
		dto.setCustomerAddress((vo.getCaddress()));
		dto.setCustomerName(vo.getCname());
		dto.setPamt(Float.parseFloat(vo.getPamt()));
		dto.setRate(Float.parseFloat(vo.getRate()));
		dto.setTime(Float.parseFloat(vo.getTime()));
		
		String result =customerserviceinterface.calculateSimpleInterest(dto);
		
		return result;
		
		
	}

}
