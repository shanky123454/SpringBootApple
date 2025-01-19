package in.com.IService;

import in.com.model.person.Person;
import in.com.model.phone.PhoneNumbers;

public interface IService {

	public String save(Person person);
	public String save(Iterable<PhoneNumbers> numbers);
	public void  fetchPerson();
	public void fetchPnos();
}
