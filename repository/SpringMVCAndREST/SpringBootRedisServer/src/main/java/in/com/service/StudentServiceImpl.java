package in.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import in.com.dao.StudentDao;
import in.com.exception.StudentNotFoundException;
import in.com.model.Student;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	public StudentDao dao;
	
	@Override
	public Student addStudent(Student student) {
		return dao.save(student);
	}

	@Override
@CachePut(value = "student",key = "#sid")// for update the data in redis cache
@Cacheable(value = "student",key = "#sid")// for getting data from redis cache
	public String updateStudent(Student s, Integer sid) {
		Optional<Student> std= Optional.empty();
		try {
		std = Optional.ofNullable(dao.findById(sid).orElseThrow(()-> new StudentNotFoundException("Student ID is not correct")));
		} catch (StudentNotFoundException e) {
			System.out.println(e.getMessage());
		}
		if(std.isPresent()) {
		std.get().setAddress(s.getAddress());
		std.get().setName(s.getName());
		 dao.save(std.get());
		 return "student got updated with id"+ std.get().getSid(); 
		}
	return "student not found with id"+sid; 
	}

	@Override
	@CacheEvict(value = "Student",key = "#sid")// for deleting from redis cache
	public String deletestudent(Integer sid) {
		Optional<Student> std=Optional.empty();
		try {
		std =Optional.ofNullable(dao.findById(sid).orElseThrow(()-> new StudentNotFoundException("not correct id")));
		} catch (StudentNotFoundException e) {
			System.out.println(e.getMessage());
		}
		if(std.isPresent()) { 
			dao.deleteById(sid);
			 return "student got deleted with id"+ std.get().getSid(); 
			}
		return "student not found with id"+sid;
	}

	@Override
	@Cacheable(value = "student",key = "#sid")// for getting data from redis cache
	public Student getOneStudent(Integer sid) {
		Student s = null;
	try {
		  s =dao.findById(sid).orElseThrow(()-> new StudentNotFoundException("Incorrect id"));
	} catch (StudentNotFoundException e) {
		System.out.println(e.getMessage());
	}
		return s;
	}

	@Override
	@Cacheable(value = "Student")// for getting all data from redis cache
	public List<Student> getAllStudent() {
		return dao.findAll(); 
	}
	
	

}
