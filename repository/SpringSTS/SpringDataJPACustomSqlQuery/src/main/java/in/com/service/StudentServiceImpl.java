package in.com.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import in.com.BO.StudentBO;
import in.com.dao.IStudentDao;

@Service
public class StudentServiceImpl implements IStudentService {
	
	@Autowired
	public IStudentDao dao;

	@Override
	public Iterable<StudentBO> findAll(boolean asc, String... properties) {
		Sort sort = Sort.by(asc ? Direction.ASC : Direction.DESC, properties);
		List<StudentBO> bo =(List<StudentBO>) dao.findAll(sort);
		return bo;
	}

	@Override
	public Page<StudentBO> findAllbypagination(int pageNo, int pageSize, boolean asc, String... properties) {
	PageRequest pageRequest =PageRequest.of(pageNo, pageSize, asc? Direction.ASC : Direction.DESC, properties);
	Page<StudentBO> bo =(Page<StudentBO>) dao.findAll(pageRequest);
	return bo;
	}

	@Override
	public void fetchDetailsByPagination(int pageSize) {
		Long count = dao.count();
		long pagesCount = count / pageSize;
		pagesCount= count%pageSize ==0 ? pagesCount : ++pagesCount;
		for (int i = 0; i < pagesCount; i++) {
			PageRequest pageRequest = PageRequest.of(i, pageSize);
			Page<StudentBO> bo = dao.findAll(pageRequest);
			bo.forEach(System.out::println);
		}
	}

	
}
