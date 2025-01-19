
package in.com.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User; 
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import in.com.dao.IUsersRepo;
import in.com.model.Role;
import in.com.model.Users; 
  
@Service
public class Usersssss implements UserDetailsService {
  
  
  @Autowired
  BCryptPasswordEncoder bCryptPasswordEncoder;
  
  @Autowired
  public IUsersRepo iTouristRepo;
  
  @Override
  public UserDetails loadUserByUsername(String username) throws
  UsernameNotFoundException {
	  
	  Users tourist = iTouristRepo.findByUsername(username);

	List<String> roleList = new ArrayList<>();
	for(Role role:tourist.getRoles()) {
		roleList.add(role.getRoleName());
	}
	   
	return User.builder() 
        	.username(tourist.getUsername())
        	.password(bCryptPasswordEncoder.encode(tourist.getPassword()))
        	.disabled(tourist.isDisabled())
        	.accountExpired(tourist.isAccountExpired())
        	.accountLocked(tourist.isAccountLocked())
        	.credentialsExpired(tourist.isCredentialsExpired())
        	.roles(roleList.toArray(new String[0]))
        	.build(); 
  }
  
  }
 