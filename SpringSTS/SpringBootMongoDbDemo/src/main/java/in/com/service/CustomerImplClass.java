package in.com.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import in.com.bo.CustomerBo;
import in.com.dao.CustomerDao;
import in.com.dto.CustomerDto;
import in.com.generator.Generator;


@Service("service")
public class CustomerImplClass implements ServiceImpl {

	@Autowired
	public CustomerDao dao;
	
	@Override
	public List<CustomerBo> getCustomer() {
	List<CustomerBo> bo =dao.findAll();
//	List<CustomerDto> dto = new ArrayList<CustomerDto>();
//	bo.forEach(b ->{
//		CustomerDto dtos = new CustomerDto();
//		BeanUtils.copyProperties(bo, dtos);
//		dto.add(dtos);
//	});
	return bo;
		
	}

	@Override
	public void registerCustomer(CustomerDto customer) {
		CustomerBo bo = new CustomerBo();
		bo.setId(Generator.generateId());
		BeanUtils.copyProperties(customer, bo);
		bo = dao.save(bo);
		System.out.println(bo);
		
	}

	@Override
	public List<CustomerDto> getByPhone(Long[] phone) {
		List<CustomerBo> bo = dao.findByCphoneIn(phone);
		bo.forEach(System.out::println);
		List<CustomerDto> dto = new ArrayList<CustomerDto>();
		bo.forEach(b->{
			CustomerDto dtos = new CustomerDto();
			BeanUtils.copyProperties(b, dtos);
			dto.add(dtos);
		});
		return dto;
	}

	@Override
	public List<CustomerDto> getByCname(String... cname) {
		List<CustomerBo> bo = dao.findByCnameIsIn(cname);
		System.out.println(bo);
		List<CustomerDto> dto = new ArrayList<CustomerDto>();
		bo.forEach(b->{
			CustomerDto dtos = new CustomerDto();
			BeanUtils.copyProperties(b, dtos);
			dto.add(dtos);
		});
		return dto;
	}

	@Override
	public List<CustomerDto> getByCid(Integer... cid) {
		List<CustomerBo> bo = dao.findByCidIsInOrderByCname(cid);
		System.out.println("yahhhooo");
		System.out.println(bo);
		List<CustomerDto> dto = new ArrayList<CustomerDto>();
		bo.forEach(b->{
			CustomerDto dtos = new CustomerDto();
			BeanUtils.copyProperties(b, dtos);
			dto.add(dtos);
		});
		return dto;
		
	}

}
