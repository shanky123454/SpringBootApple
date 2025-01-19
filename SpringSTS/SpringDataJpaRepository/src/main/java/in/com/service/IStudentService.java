package in.com.service;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;

import in.com.BO.StudentBO;
import in.com.DTO.StudentDTO;

public interface IStudentService {
	
	public int insert(StudentDTO s);
	
	public Iterable<StudentBO> insertInBatch(Iterable<StudentDTO> bo);

	public boolean existsById(int id);
	
	public void delete(int id);

	public void delete(StudentDTO s);

	public void update(StudentDTO s);

	public StudentDTO getStudent( Integer id);
	
	public StudentDTO getReferenceById( Integer id);

	public Iterable<StudentDTO> getAllStudents();
	
	public Iterable<StudentDTO> findAllById(Iterable<Integer> ids);
	
	public Long totalStudent();
	
	public void deleteAllById(Iterable<Integer> ids);
	
	public void deleteAllById1(Iterable<? extends Integer> ids);
	
	public List<StudentDTO> findAll( boolean bool, String... properties);
	
	public void flush();
	
	public List<StudentDTO> findAll(StudentBO bo);
	
	public List<StudentDTO> findAll(StudentBO bo,Boolean bool);

}
