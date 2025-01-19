package in.com.IService;

import java.util.List;

import in.com.model.MarutiSuzukiCar.MarutiSuzukiCar;
import in.com.model.person.Customer;

public interface IService {

	public String savePerson(List<Customer> person);
	public String saveCars(List<MarutiSuzukiCar> cars);
	public void  fetchPerson();
	public void fetchCars();
	public String deleteCar(Integer pid);
	public String deleteAllCustomersByCarId(Integer id);
}
