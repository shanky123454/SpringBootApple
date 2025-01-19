package in.com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.com.DTO.EmployeeDTO;
import in.com.VO.EmployeeVO;
import in.com.service.IEmployeeService;

@Component(value = "empController")
public class EmployeeController {
	
	static {
		System.out.println("EmployeeController.static method()");
	}
	
	public EmployeeController()
	{
		System.out.println("EmployeeController.EmployeeController()");
	}
	
	@Autowired
	public IEmployeeService iEmployeeService;
	
	public List<EmployeeVO> getEmpByDesg(String[] desg)
	{
		List<EmployeeDTO> employeeDTO = new ArrayList<>();
		employeeDTO = iEmployeeService.getEmpByDesg(desg);
		
		List<EmployeeVO> employeeVO = new ArrayList<>();
		employeeDTO.forEach(dto->{
			EmployeeVO vo = new EmployeeVO();
			BeanUtils.copyProperties(dto,vo);
			vo.setSrNo(String.valueOf(dto.getSrNo()));
			vo.setEmpNo(String.valueOf(dto.getEmpNo()));
			vo.setSal(String.valueOf(dto.getSal()));
			vo.setDeptNo(String.valueOf(dto.getDeptNo()));
			vo.setMgrNo(String.valueOf(dto.getMgrNo()));
			employeeVO.add(vo);
		});
		
		return employeeVO;
	}

}
