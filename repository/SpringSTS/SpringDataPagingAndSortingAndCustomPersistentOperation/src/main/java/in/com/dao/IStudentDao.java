package in.com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import in.com.BO.StudentBO;
import in.com.Type.ResultView;
import in.com.dynamic.ResultViewDynamic;

@Repository
public interface IStudentDao extends JpaRepository<StudentBO, Integer>{

	public List<StudentBO> findBysname(String sname);
	public List<StudentBO> findBysnameIn(String... sname);
	public List<StudentBO> findBysidGreaterThanEqual(int sid);
	public List<StudentBO> findBysidGreaterThanEqualOrderBySageDesc(int sid);
	public List<StudentBO> findBySageIsIn(int ... age);
	public List<ResultView> findBySidIsIn(int... sid);
	public <T extends ResultViewDynamic> List<T> findBySname(Class<T> args,String name);
	public <T extends ResultViewDynamic> List<T> findBySid(Class<T> args,int sid);




}

