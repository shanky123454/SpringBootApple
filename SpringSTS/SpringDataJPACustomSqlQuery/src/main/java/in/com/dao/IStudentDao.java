package in.com.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import in.com.BO.StudentBO;

@Repository
public interface IStudentDao extends PagingAndSortingRepository<StudentBO, Integer>{

	
}

