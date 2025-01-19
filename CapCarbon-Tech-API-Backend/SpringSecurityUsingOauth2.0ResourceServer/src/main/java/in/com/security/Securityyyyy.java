
  package in.com.security;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import static org.springframework.security.config.Customizer.withDefaults; 

  @Configuration
@EnableWebSecurity
 public class Securityyyyy extends WebSecurityConfigurerAdapter{
 
 @Override
  public void configure(HttpSecurity http) throws Exception {

     http.csrf(csrf -> csrf.disable()).authorizeRequests(requests -> requests
             .antMatchers("/demo/home") .permitAll()
             .antMatchers("/demo/details") .hasAnyRole("ADMIN")
             .antMatchers("/demo/user") .hasAuthority("USER")
            .anyRequest()
             .authenticated()) .formLogin(withDefaults());
  }
  
 @Override
 public void configure(AuthenticationManagerBuilder auth) throws Exception 
 { 
	 auth.inMemoryAuthentication().withUser("shanky")
  .password(("{noop}shanky@123")) .roles("ADMIN");
  
  auth.inMemoryAuthentication().withUser("ritu")
  .password(("{noop}ritu@123")) .roles("USER");
}
 
 
}