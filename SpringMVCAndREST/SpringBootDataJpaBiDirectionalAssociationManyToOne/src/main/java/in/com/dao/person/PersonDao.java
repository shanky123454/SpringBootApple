package in.com.dao.person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.com.model.person.Customer;

@Repository
public interface PersonDao extends JpaRepository<Customer,Integer> {

}
