package in.com.IserviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.com.IService.IService;
import in.com.dao.MarutiSuzukiCar.MarutiSuzukiCarDao;
import in.com.dao.person.PersonDao;
import in.com.model.MarutiSuzukiCar.MarutiSuzukiCar;
import in.com.model.person.Customer;

@Service
public class IServiceImpl implements IService {

	@Autowired
	public PersonDao dao;

	@Autowired
	public MarutiSuzukiCarDao dao2;

	@Override
	public String save(List<Customer> person) {
		person.forEach(t-> dao.save(t));
		return "person is saved";
	}

	@Override
	public String save1(List<MarutiSuzukiCar> cars) {
	cars.forEach(t->dao2.save(t));
	
		return "car are saved";
	}

	@Override
	public void fetchPersonById(Integer id) {
	Optional<Customer> optional =	dao.findById(id);
	if(optional.isPresent()) {
	Customer customer =	optional.get();
	System.out.println(customer);
	}
		
	}

	@Override
	public void fetchCarsById(Integer id) {
	Optional<MarutiSuzukiCar> optional =	dao2.findById(id);
	if(optional.isPresent()) {
		MarutiSuzukiCar customer  =	optional.get();
		System.out.println(customer);
		}
	}


	

	/*
	 * @Override public String save(List<MarutiSuzukiCar> cars) { MarutiSuzukiCar
	 * car = dao2.save(cars); return "MarutiSuzukiCar is saved with no:"+
	 * car.getCarNo(); }
	 * 
	 * 
	 * @Override public String save(List<Customer> person) { for (Customer person2 :
	 * person) { Customer person1 = dao.save(person2); System.out.println(person1);
	 * } return "person is saved"; }
	 */
	  
	  
	/*
	 * @Override public void fetchPerson() { dao.findAll().forEach(Person->{
	 * System.out.println(Person); MarutiSuzukiCar car =Person.getCar();
	 * System.out.println(car); }); }
	 * 
	 * @Override public void fetchCars() { dao2.findAll().forEach(t ->{
	 * System.out.println(t); List<Customer> personList = t.getPerson();
	 * personList.forEach(v->{ System.out.println(v); }); });
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * @Override public String deleteCar(Integer pid) { Optional<MarutiSuzukiCar>
	 * optional = dao2.findById(pid); if(optional.isPresent()) {
	 * dao2.delete(optional.get()); } return "Car is successfully deleted"; }
	 * 
	 * 
	 * @Override public String deleteAllCustomersByCarId(Integer id) {
	 * Optional<MarutiSuzukiCar> optional = dao2.findById(id); if
	 * (optional.isPresent()) { List<Customer> list = optional.get().getPerson();
	 * list.forEach(t -> { t.setCar(null); }); dao.deleteAll(list); }
	 * 
	 * return "All customers have been deleted"; }
	 */

}
