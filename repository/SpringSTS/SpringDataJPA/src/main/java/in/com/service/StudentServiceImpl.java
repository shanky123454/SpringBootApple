package in.com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import in.com.BO.StudentBO;
import in.com.DTO.StudentDTO;
import in.com.dao.IStudentDao;

@Service
public class StudentServiceImpl implements IStudentService {
	
	@Autowired
	public IStudentDao dao;

	@Override
	public int insert(StudentDTO s) {
		StudentBO bo = new StudentBO();
		BeanUtils.copyProperties(s, bo);
		dao.save(bo);
		return bo.getSid();
	}

	@Override
	public void delete(int id) {
		dao.deleteById(id);
	}

	@Override
	public void delete(StudentDTO s) {
		StudentBO bo = new StudentBO();
		BeanUtils.copyProperties(s, bo);
		dao.delete(bo);
	}

	@Override
	public void update(StudentDTO s) {
		StudentBO bo = new StudentBO();
		BeanUtils.copyProperties(s, bo);
		dao.save(bo);
	}

	@Override
	public StudentDTO getStudent(int id) {
      Optional<StudentBO> stdbo =   dao.findById(id);
      StudentBO bo= stdbo.get();
      StudentDTO dto = new StudentDTO();
      BeanUtils.copyProperties(bo, dto);
      return dto;
	}

	@Override
	public List<StudentDTO> getAllStudents() {
	List<StudentDTO> dto = new ArrayList<StudentDTO>();
	Iterable<StudentBO> bo = dao.findAll();
	bo.forEach(boa->{
		StudentDTO dto1 = new StudentDTO();
		BeanUtils.copyProperties(boa, dto1);
		dto.add(dto1);
	});
	return dto;
	}

	@Override
	public Iterable<StudentBO> insertInBatch(Iterable<StudentDTO> dto) {
		List<StudentBO> boo = new ArrayList<StudentBO>();
		dto.forEach(dtoo-> {
			StudentBO bo = new StudentBO();
			BeanUtils.copyProperties(dtoo, bo);
			boo.add(bo);
		});
		
		return dao.saveAll(boo);
		
	}

	@Override
	public boolean existsById(int id) {
	boolean b =	dao.existsById(id);
		return b;
	}

	@Override
	public Iterable<StudentDTO> findAllById(Iterable<Integer> ids) {
	List<StudentDTO> dtos = new ArrayList<StudentDTO>();
	Iterable<StudentBO> bo =dao.findAllById(ids);
	bo.forEach(booa -> {
		StudentDTO dtos1 = new StudentDTO();
		BeanUtils.copyProperties(booa, dtos1);
		dtos.add(dtos1);
	});
		return dtos;
	}

	@Override
	public Long totalStudent() {
		Long count =dao.count();
		return count;
	}

	@Override
	public void deleteAllById(Iterable<Integer> ids) {
			dao.deleteAllById(ids);
	}

	@Override
	public void deleteAllById1(Iterable<? extends Integer> ids) {
		dao.deleteAllById(ids);
		
	}
	
	


}
