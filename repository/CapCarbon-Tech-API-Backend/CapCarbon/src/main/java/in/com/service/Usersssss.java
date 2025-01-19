/*
 * package in.com.service;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.security.core.userdetails.User; import
 * org.springframework.security.core.userdetails.UserDetails; import
 * org.springframework.security.core.userdetails.UserDetailsService; import
 * org.springframework.security.core.userdetails.UsernameNotFoundException;
 * import org.springframework.stereotype.Service; import
 * in.com.config.UserConfigurationIdea; import in.com.dao.ITouristRepo; import
 * in.com.model.Tourist;
 * 
 * @Service public class Usersssss implements UserDetailsService {
 * 
 * 
 * @Autowired public UserConfigurationIdea configurationIdea;
 * 
 * 
 * @Autowired public ITouristRepo iTouristRepo;
 * 
 * @Override public UserDetails loadUserByUsername(String username) throws
 * UsernameNotFoundException { Tourist tourist = iTouristRepo.findBy(username);
 * if(tourist==null) { throw new UsernameNotFoundException("NO USER"); } return
 * new User(tourist.getUsername(), tourist.getPassword(), true, true, true,
 * true, configurationIdea.getAuthorities()); }
 * 
 * }
 */