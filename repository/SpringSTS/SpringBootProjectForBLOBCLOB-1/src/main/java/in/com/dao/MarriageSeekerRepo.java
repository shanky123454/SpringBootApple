package in.com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.com.bo.MarriageSeeker;

@Repository
public interface MarriageSeekerRepo extends JpaRepository<MarriageSeeker, Integer> {

}
