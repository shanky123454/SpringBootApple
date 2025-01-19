package in.com.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import in.com.BO.StudentBO;
import in.com.Type.ResultView;
import in.com.dao.IStudentDao;
import in.com.dynamic.ResultView1;
import in.com.dynamic.ResultView2;
import in.com.dynamic.ResultView3;
import in.com.dynamic.ResultViewDynamic;

@Service
public class StudentServiceImpl implements IStudentService {
	
	@Autowired
	public IStudentDao dao;
	
	public EntityManager entityManager;

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

	@Override
	public List<StudentBO> findBysname(String sname) {
	List<StudentBO> bo =dao.findBysname(sname);
		return bo;
	}

	@Override
	public List<StudentBO> findBysnameIn(String... sname) {
		List<StudentBO> bo =dao.findBysnameIn(sname);
		return bo;
	}

	@Override
	public List<StudentBO> findBysidGreaterThanEqual(int sid){
    List<StudentBO> bo = dao.findBysidGreaterThanEqual(sid);
		return bo;
	}

	@Override
	public List<StudentBO> findBysidGreaterThanEqualOrderBySageDesc(int sid) {
		 List<StudentBO> bo = dao.findBysidGreaterThanEqualOrderBySageDesc(sid);
		return bo;
	}

	@Override
	public List<StudentBO> findBySageIsIn(int... age) {
		List<StudentBO> bo = dao.findBySageIsIn(age);
		return bo;
	}

	@Override
	// static projection
	public List<ResultView> findBySidIsIn(int... sid) {
		List<ResultView> resultViews = dao.findBySidIsIn(sid);
		return resultViews;
	}

	@SuppressWarnings("unchecked")
	@Override
	// Dynamic projection
	public <T extends ResultViewDynamic> List<T> findBySname(Class<T> args, String name) {
		List<ResultView3> list = dao.findBySname(ResultView3.class, name);
		return  (List<T>) list;
	}

	@SuppressWarnings("unchecked")
	@Override
	// Dynamic projection
	public <T extends ResultViewDynamic> List<T> findBySid(Class<T> args, int sid) {
		List<ResultView2> list = dao.findBySid(ResultView2.class, sid);
		return  (List<T>) list;
	}
	
	

	
}
