
package in.com.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User; 
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import in.com.dao.IUsersRepo;
import in.com.model.Role;
import in.com.model.Users; 
  
@Service
public class Usersssss implements UserDetailsService {

	@Autowired
	public BCryptPasswordEncoder bCryptPasswordEncoder;
  
  @Autowired
  public IUsersRepo iTouristRepo;
  
  @Override
  public UserDetails loadUserByUsername(String username) throws
  UsernameNotFoundException {
	  
	  Users tourist = iTouristRepo.findByUsername(username);

	  if (tourist == null) {
		throw new UsernameNotFoundException("not found");
	}  
	  
	  List<SimpleGrantedAuthority> grantList = new ArrayList<>();
		 List<Role> roleNames =  tourist.getRoles();
		if (roleNames != null) {
         for (Role role : roleNames) {
         	SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getRoleName());
             grantList.add(authority);
         } 
     }
	  
	  return User.builder() 
	        	.username(tourist.getUsername())
	        	.password(bCryptPasswordEncoder.encode(tourist.getPassword()))
	        	.disabled(tourist.isDisabled())
	        	.accountExpired(tourist.isAccountExpired())
	        	.accountLocked(tourist.isAccountLocked())
	        	.credentialsExpired(tourist.isCredentialsExpired())
	        	.authorities(grantList)
	        	.build(); 
  }
  
  }
 