package in.com.service;

import java.util.ArrayList;
import java.util.List;

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
       int result = dao.insert(bo);
		return  result;
	}

	@Override
	public void delete(int id) {
		dao.delete(id);
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
		 dao.update(bo);
	}

	@Override
	public StudentDTO getStudent(int id) {
    StudentDTO dto = null;
	StudentBO bo =dao.getStudent(id);
	if(bo!=null) 
	{
		dto =new StudentDTO();
	  BeanUtils.copyProperties(bo, dto);
	}
	return dto; 
	}

	@Override
	public List<StudentDTO> getAllStudents() {
		List<StudentDTO> dtos =new ArrayList<>();
	List<StudentBO> bos =	dao.getAllStudents();
	if(bos!=null)
	{
		 bos.forEach((t)->{
			StudentDTO dto = new StudentDTO();
			BeanUtils.copyProperties(t, dto);
			dtos.add(dto);
		});
	}
	return dtos;	
	}

}
