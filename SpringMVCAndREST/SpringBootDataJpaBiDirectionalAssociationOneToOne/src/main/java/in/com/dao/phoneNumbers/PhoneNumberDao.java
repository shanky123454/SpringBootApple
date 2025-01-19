package in.com.dao.phoneNumbers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.com.model.phone.PhoneNumbers;

@Repository
public interface PhoneNumberDao extends JpaRepository<PhoneNumbers,Integer> {

}
