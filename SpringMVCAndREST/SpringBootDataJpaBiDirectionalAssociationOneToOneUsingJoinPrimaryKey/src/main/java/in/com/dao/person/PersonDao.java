package in.com.dao.person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.com.model.person.Person;

@Repository
public interface PersonDao extends JpaRepository<Person,Integer> {

}
