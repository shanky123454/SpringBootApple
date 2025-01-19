package in.com.IserviceImpl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.com.IService.IService;
import in.com.dao.person.PersonDao;
import in.com.dao.phoneNumbers.PhoneNumberDao;
import in.com.model.person.Person;
import in.com.model.phone.PhoneNumbers;

@Service
public class IServiceImpl implements IService {

	@Autowired
	public PersonDao dao;
	
	@Autowired
	public PhoneNumberDao dao2;
	
	@Override
	public String save(Person person) {
	Person person2 =dao.save(person);
	System.out.println(person2);
		return "person is saved with id :"+ person.getPid();
	}

	@Override
	public String save(Iterable<PhoneNumbers> numbers) {
		for (PhoneNumbers phoneNumbers : numbers) {
			PhoneNumbers numbers2 = dao2.save(phoneNumbers);
			System.out.println(numbers2);
		}
		return "phone number is saved";
	}

	@Override
	public void fetchPerson() {
		dao.findAll().forEach(Person->{
			System.out.println(Person);
		Set<PhoneNumbers> numbers =Person.getNumbers();
		numbers.forEach(t ->{
			System.out.println(t);
		});
		});
	}

	@Override
	public void fetchPnos() {
		dao2.findAll().forEach(PhoneNumbers ->{
			System.out.println(PhoneNumbers);
			Person person = PhoneNumbers.getPerson();
			System.out.println(person);
		});
		
	}

}
