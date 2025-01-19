package in.com.IserviceImpl;

import java.util.ArrayList;
import java.util.List;
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
	public String savePhoneNumbers(PhoneNumbers number) {
		
		dao2.save(number);
		return "phone number is saved";
	}

	@Override
	public void fetchPerson() {
		dao.findAll().forEach(Person->{
			Person.getNumbers().setProvider("JIO");
			dao.save(Person);
			System.out.println(Person);
		});	
     }

	@Override
	public void fetchPnos() {
		dao2.findAll().forEach(PhoneNumbers ->{
			PhoneNumbers.getPerson().setPname("shashank");
			dao2.save(PhoneNumbers);
			System.out.println(PhoneNumbers);
			System.out.println(PhoneNumbers.getPerson().getPid());
		});
		
	}

}
