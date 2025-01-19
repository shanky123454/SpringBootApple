package in.com.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import in.com.bo.CustomerBo;
import in.com.dto.CustomerDto;


@Repository
public interface CustomerDao extends MongoRepository<CustomerBo,String> {

public List<CustomerBo> findByCphoneIn(Long[] cphone);

public List<CustomerBo> findByCnameIsIn(String... cname);

public List<CustomerBo> findByCidIsInOrderByCname(Integer... cid);


}
