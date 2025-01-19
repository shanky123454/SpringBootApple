package in.com.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import in.com.BO.EmployeeDTO;
import in.com.dao.IStudentDao;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	public IStudentDao dao;


	@Override
	public void Insert(EmployeeDTO dto) {
	EmployeeDTO dtos =dao.saveAndFlush(dto);
		System.out.println(dtos);
	}
	
	
}
