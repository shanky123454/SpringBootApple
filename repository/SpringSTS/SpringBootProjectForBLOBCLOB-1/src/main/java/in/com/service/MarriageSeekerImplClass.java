package in.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.com.bo.MarriageSeeker;
import in.com.dao.MarriageSeekerRepo;

@Service(value = "service")
public class MarriageSeekerImplClass implements MarriageSeekerInterface {

	@Autowired
	public MarriageSeekerRepo repo;
	
	@Override
	public MarriageSeeker registerMarriage(MarriageSeeker marriageSeeker) {
	return	repo.save(marriageSeeker);	
	}

	@Override
	public MarriageSeeker getRegisteredMarriage(Integer id) {
     return repo.getReferenceById(id);
	}

}
