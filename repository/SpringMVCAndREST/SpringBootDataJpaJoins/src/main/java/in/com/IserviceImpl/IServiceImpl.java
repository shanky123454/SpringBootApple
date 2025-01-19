package in.com.IserviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.com.IService.IService;
import in.com.dao.MarutiSuzukiCar.MarutiSuzukiCarDao;
import in.com.dao.person.PersonDao;

@Service
public class IServiceImpl implements IService {

	@Autowired
	public PersonDao dao;

	@Autowired
	public MarutiSuzukiCarDao dao2;

	@Override
	public List<Object[]> fetchDataByJoinsUsingCar() {
	 return dao2.fetchDataByJoinsByParent();
	
	}

	@Override
	public List<Object[]> fetchDataByJoinsUsingCustomer() {
		return dao.fetchDataByJoinsByChild();
	}

	
	  

}
