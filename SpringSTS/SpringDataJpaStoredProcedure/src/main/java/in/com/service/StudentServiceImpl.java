package in.com.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import in.com.BO.EmployeeDTO;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	public EntityManager entityManager;
	
	@Override
	public List<EmployeeDTO> fetchEmployeeDTOById(int id1, int id2) {
	StoredProcedureQuery  query =entityManager.createStoredProcedureQuery("shashank", EmployeeDTO.class);
	query.registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN);
	query.registerStoredProcedureParameter(2, Integer.class, ParameterMode.IN);
	
	query.setParameter(1, id1);
	query.setParameter(2, id2);
	
	@SuppressWarnings("unchecked")
	List<EmployeeDTO> dto = query.getResultList();
	return dto;
	}
	
	
}
