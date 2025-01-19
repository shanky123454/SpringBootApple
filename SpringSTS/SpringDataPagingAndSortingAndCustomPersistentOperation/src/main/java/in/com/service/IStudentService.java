package in.com.service;

import java.util.List;

import org.springframework.data.domain.Page;

import in.com.BO.StudentBO;
import in.com.Type.ResultView;
import in.com.dynamic.ResultViewDynamic;

public interface IStudentService {
	
	Iterable<StudentBO> findAll(boolean asc, String... properties);
	Page<StudentBO> findAllbypagination(int pageNo, int pageSize, boolean asc, String... properties);
	public void fetchDetailsByPagination(int pageSize);
	public List<StudentBO> findBysname(String sname);
	public List<StudentBO> findBysnameIn(String... sname);
	public List<StudentBO> findBysidGreaterThanEqual(int sid);
	public List<StudentBO> findBysidGreaterThanEqualOrderBySageDesc(int sid);
	public List<StudentBO> findBySageIsIn(int ... age);
	public List<ResultView> findBySidIsIn(int... sid);
	public <T extends ResultViewDynamic> List<T> findBySname(Class<T> args,String name);
	public <T extends ResultViewDynamic> List<T> findBySid(Class<T> args,int sid);





}
