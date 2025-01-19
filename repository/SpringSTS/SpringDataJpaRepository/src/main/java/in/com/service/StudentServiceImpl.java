package in.com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
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
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public StudentDTO getStudent(Integer id) {
	StudentBO stdbo = dao.getById(id);
      StudentDTO dto = new StudentDTO();
      BeanUtils.copyProperties(stdbo, dto);
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

	@Override
	public List<StudentDTO> findAll(boolean bool, String... properties) {
		Sort sort = Sort.by(bool ? Direction.ASC:Direction.DESC, properties);
		List<StudentBO> listbo =(List<StudentBO>) dao.findAll();
		List<StudentDTO> dtos = new ArrayList<StudentDTO>();
		listbo.forEach(bo -> {
			StudentDTO dto = new StudentDTO();
			BeanUtils.copyProperties(bo, dto);
			dtos.add(dto);
		});
		return dtos;
	}

	@Override
	public void flush() {
       dao.flush();		
	}

	@Override
	public StudentDTO getReferenceById(Integer id) {
	Optional<StudentBO> bo =Optional.of(dao.getReferenceById(id));
	StudentBO bos = bo.get();
	StudentDTO dto = new StudentDTO();
	BeanUtils.copyProperties(bos, dto);
		return dto;
	}

	@Override
	public List<StudentDTO> findAll(StudentBO bo) {

		Example<StudentBO> example = Example.of(bo);
	   List<StudentBO> dtos =dao.findAll(example);

		List<StudentDTO> dto = new ArrayList<>();
		dtos.forEach(obj -> {
			StudentDTO dtoss = new StudentDTO();
			BeanUtils.copyProperties(obj, dtoss);
			dto.add(dtoss);
		});
		return dto;
	}

	@Override
	public List<StudentDTO> findAll(StudentBO bo, Boolean bool) {

		Example<StudentBO> example= Example.of(bo);
		Sort sort = Sort.by( bool ? Direction.ASC: Direction.DESC, "sage");
	List<StudentBO> boo =dao.findAll(example,sort);
	List<StudentDTO> dto = new ArrayList<>();
	boo.forEach(b->{
		StudentDTO dtow = new StudentDTO();
		BeanUtils.copyProperties(b, dtow);
		dto.add(dtow);
	});
		return dto;
	}

	

	
	


}
