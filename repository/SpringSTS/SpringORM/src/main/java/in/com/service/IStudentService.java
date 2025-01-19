package in.com.service;

import java.util.List;
import in.com.DTO.StudentDTO;

public interface IStudentService {
	
	public int insert(StudentDTO s);

	public void delete(int id);

	public void delete(StudentDTO s);

	public void update(StudentDTO s);

	public StudentDTO getStudent(int id);

	public List<StudentDTO> getAllStudents();
}
