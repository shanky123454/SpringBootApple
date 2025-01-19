package in.com.service;

import org.springframework.data.domain.Page;

import in.com.BO.StudentBO;

public interface IStudentService {
	
	Iterable<StudentBO> findAll(boolean asc, String... properties);
	Page<StudentBO> findAllbypagination(int pageNo, int pageSize, boolean asc, String... properties);
	public void fetchDetailsByPagination(int pageSize);
}
