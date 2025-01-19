package in.com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import in.com.model.Users;


public interface IUsersRepo extends JpaRepository<Users, Integer> {
   //   public Users findByUsername(String username);
}
