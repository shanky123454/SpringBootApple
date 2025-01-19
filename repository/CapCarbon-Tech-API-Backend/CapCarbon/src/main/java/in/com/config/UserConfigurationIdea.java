/*
 * package in.com.config;
 * 
 * import java.util.Collection; import java.util.HashSet;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.security.core.GrantedAuthority; import
 * org.springframework.security.core.authority.SimpleGrantedAuthority; import
 * org.springframework.security.core.userdetails.UserDetails; import
 * org.springframework.stereotype.Component;
 * 
 * import in.com.model.Tourist;
 * 
 * @Component public class UserConfigurationIdea implements UserDetails {
 * 
 * private static final long serialVersionUID = 1L;
 * 
 * @Autowired public Tourist tourist;
 * 
 * @Override public Collection<? extends GrantedAuthority> getAuthorities() {
 * HashSet<SimpleGrantedAuthority> set= new HashSet<SimpleGrantedAuthority>();
 * set.add(new SimpleGrantedAuthority(this.tourist.getRole())); return set; }
 * 
 * @Override public String getPassword() { return this.tourist.getPassword();
 * 
 * }
 * 
 * @Override public String getUsername() { return this.tourist.getUsername(); }
 * 
 * @Override public boolean isAccountNonExpired() {
 * 
 * return true; }
 * 
 * @Override public boolean isAccountNonLocked() { // TODO Auto-generated method
 * stub return true; }
 * 
 * @Override public boolean isCredentialsNonExpired() { // TODO Auto-generated
 * method stub return true; }
 * 
 * @Override public boolean isEnabled() { // TODO Auto-generated method stub
 * return true; }
 * 
 * 
 * }
 */