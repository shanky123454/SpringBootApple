package in.com.IService;

import java.util.List;

import in.com.model.MarutiSuzukiCar.MarutiSuzukiCar;
import in.com.model.person.Customer;

public interface IService {

public String save(List<Customer> person);

public String save1(List<MarutiSuzukiCar> cars);
	

  public void fetchPersonById(Integer id );
  
  public void fetchCarsById(Integer id);
	/*
	 * public String deleteCar(Integer pid); public String
	 * deleteAllCustomersByCarId(Integer id);
	 */
 
}
