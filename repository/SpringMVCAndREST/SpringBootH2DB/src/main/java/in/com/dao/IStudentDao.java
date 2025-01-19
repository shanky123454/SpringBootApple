package in.com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.com.model.Cricketer;


@Repository
public interface IStudentDao extends JpaRepository<Cricketer,Integer> {

}
