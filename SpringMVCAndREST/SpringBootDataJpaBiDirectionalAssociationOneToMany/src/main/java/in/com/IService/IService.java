package in.com.IService;

import java.util.ArrayList;
import java.util.List;

import in.com.model.person.Person;
import in.com.model.phone.PhoneNumbers;

public interface IService {

	public String save(Person person);
	public String savePhoneNumbers(ArrayList<PhoneNumbers> numbers);
	public void  fetchPerson();
	public void fetchPnos();
}
