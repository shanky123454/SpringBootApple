package in.com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import in.com.BO.EmployeeDTO;


@Repository
public interface IStudentDao extends JpaRepository<EmployeeDTO, Integer>{

}

