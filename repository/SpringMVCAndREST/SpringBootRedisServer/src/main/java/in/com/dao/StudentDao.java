package in.com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.com.model.Student;


@Repository
public interface StudentDao extends JpaRepository<Student,Integer> {

}
