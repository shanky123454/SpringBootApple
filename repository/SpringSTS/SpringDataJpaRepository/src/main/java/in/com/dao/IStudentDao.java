package in.com.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.com.BO.StudentBO;

@Repository
public interface IStudentDao extends JpaRepository<StudentBO, Integer>{

	
}

