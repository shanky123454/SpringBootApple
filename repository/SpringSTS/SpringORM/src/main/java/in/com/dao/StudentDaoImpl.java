package in.com.dao;

import java.io.Serializable;
import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.com.BO.StudentBO;


@Repository
@Transactional
public class StudentDaoImpl implements IStudentDao {
	
	@Autowired
	public HibernateTemplate hibernateTemplate;

	@Override
	public int insert(StudentBO s) {
	Serializable i =hibernateTemplate.save(s);
		return (int) i;
	}

	@Override
	public void delete(int id) {
	StudentBO bo = hibernateTemplate.get(StudentBO.class, id);
	if(bo!=null)
	{
		hibernateTemplate.delete(bo);
		System.out.println("record successfully deleted with given id:" +id);
	}
	else {
		System.out.println("record not available to delete" + id);
	}
	}

	@Override
	public void delete(StudentBO s) {
		hibernateTemplate.delete(s);
		
	}

	@Override
	public void update(StudentBO s) {
			hibernateTemplate.update(s);
	}

	@Override
	public StudentBO getStudent(int id) {
	  StudentBO bo =  hibernateTemplate.get(StudentBO.class, id);
	  return bo;
	}

	@Override
	public List<StudentBO> getAllStudents() {
		List<StudentBO> bo = hibernateTemplate.loadAll(StudentBO.class);
		return bo;
	}

}
