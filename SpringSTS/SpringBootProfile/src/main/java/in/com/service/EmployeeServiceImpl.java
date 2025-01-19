package in.com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import in.com.BO.EmployeeBO;
import in.com.DTO.EmployeeDTO;
import in.com.dao.IEmployeeDao;

@Component(value = "employeeServiceImpl")
public class EmployeeServiceImpl implements IEmployeeService {
	
	static {
		System.out.println("EmployeeServiceImpl.static_method()");
	}
	
	public EmployeeServiceImpl()
	{
		System.out.println("EmployeeServiceImpl.EmployeeServiceImpl()");
	}
	
	@Autowired
	public IEmployeeDao employeeDao;

	@Override
	public List<EmployeeDTO> getEmpByDesg(String[] desg) {
		List<EmployeeBO> employeeBO = new ArrayList<>();
		
		StringBuilder builder = new StringBuilder("(");
		for(int i=0;i<desg.length;i++)
		{
			if(i==desg.length-1)
			{
				builder.append("'" + desg[i] + "')");
			}
			else {
				builder.append("'" + desg[i] + "',");
			}
		}
		String cond = builder.toString();
		
	    char[] c = {'a','b'};
		String s = new String(c);
		System.out.println(s);
		char[] c1 = new char[2];
		char a = 'w';
		String s1= new String(Character.toString(a));
		System.out.println(s1);
		
		employeeBO =  employeeDao.getEmpByDesg(cond);
		List<EmployeeDTO> employeeDTO = new ArrayList<>();
		employeeBO.forEach(bo->{
			EmployeeDTO dto = new EmployeeDTO();
			BeanUtils.copyProperties(bo, dto);
			dto.setSrNo(employeeDTO.size()+1);
			System.out.println(dto);
			employeeDTO.add(dto);
		});
		
		return employeeDTO;
	}

}
