package in.com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.com.dao.IStudentDao;
import in.com.exception.CricketerNotFoundException;
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
		Optional<Cricketer> optional =	Optional.ofNullable(dao.findById(id)
				.orElseThrow(()-> new CricketerNotFoundException("Cricketer with id is not present")));
		/* 
		 * if(optional.isPresent()) return optional.get(); else return null;
		 */ 
		return optional.get();
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
		Optional<Cricketer> cricketer = Optional.ofNullable(dao.findById(id)
				.orElseThrow(()-> new CricketerNotFoundException("Cricketer with id is not present")));
	
		dao.delete(cricketer.get());
		/*
		 * if(cricketer.isPresent()) { dao.deleteById(id); return
		 * "Cricketer is deleted with id:" + id;} else return
		 * "record not available for the id:" + id;
		 */
		return "Cricketer deleted with id" + id;
	}
}
