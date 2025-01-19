package in.com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.com.dao.IStudentDao;
import in.com.model.Cricketer;

@Service
public class IServiceImpl implements IService {

	@Autowired
	public IStudentDao dao;
	
	@SuppressWarnings("null")
	@Override 
	public String register(Cricketer cricketer) {
	Cricketer cricketer2 =	dao.save(cricketer);
	if(cricketer2 != null)
		return "Cricketer is inserted with id" + cricketer2.getId();
	else
		return "Not Inserted with the given id"+ cricketer2.getId();
		
	}

	@Override
	public List<Cricketer> findall() {
		List<Cricketer> cricketerlist= new ArrayList<Cricketer>();	
	 cricketerlist=dao.findAll();
		return cricketerlist;
	}
  
	@Override
	public Cricketer findById(Integer id) {
		Optional<Cricketer> optional =	dao.findById(id);
		if(optional.isPresent()) 
       return optional.get();
			else 
				return null;  
	} 

	@Override
	public String updateById(Cricketer cricketer) {
	Cricketer cricketer2 =	dao.save(cricketer);
		if(cricketer2 != null)
			return "Cricketer is updated with id" + cricketer2.getId();
		else
			return "Cricketer not updated with given id"+ cricketer2.getId();
			
	}

	@Override
	public String deleteById(Integer id) {
		dao.deleteById(id);
		return "Cricketer is deleted with id:" + id;
	}
}
