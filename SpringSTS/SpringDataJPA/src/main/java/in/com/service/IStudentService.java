package in.com.service;

import in.com.BO.StudentBO;
import in.com.DTO.StudentDTO;

public interface IStudentService {
	
	public int insert(StudentDTO s);
	
	public Iterable<StudentBO> insertInBatch(Iterable<StudentDTO> bo);

	public boolean existsById(int id);
	
	public void delete(int id);

	public void delete(StudentDTO s);

	public void update(StudentDTO s);

	public StudentDTO getStudent(int id);

	public Iterable<StudentDTO> getAllStudents();
	
	public Iterable<StudentDTO> findAllById(Iterable<Integer> ids);
	
	public Long totalStudent();
	
	public void deleteAllById(Iterable<Integer> ids);
	
	public void deleteAllById1(Iterable<? extends Integer> ids);
}
