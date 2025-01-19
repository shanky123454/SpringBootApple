
  package in.com.securityConfig;
  
  
  import org.springframework.context.annotation.Bean; import
  org.springframework.context.annotation.Configuration; import
  org.springframework.security.config.annotation.web.builders.HttpSecurity;
  import org.springframework.security.config.annotation.web.configuration.
  EnableWebSecurity; import org.springframework.security.core.userdetails.User;
  import org.springframework.security.core.userdetails.UserDetails; import
  org.springframework.security.core.userdetails.UserDetailsService; import
  org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; import
  org.springframework.security.crypto.password.PasswordEncoder; import
  org.springframework.security.provisioning.InMemoryUserDetailsManager; import
  org.springframework.security.web.SecurityFilterChain;
  
  
  @Configuration
  
  @EnableWebSecurity public class SecurityConfigClass {
  
  
  @Bean public PasswordEncoder passwordEncoder() { return new
  BCryptPasswordEncoder(); }
  
  @Bean public UserDetailsService userDetailsService() {
  
  UserDetails normalUser = User.withUsername("shanky")
  .password(passwordEncoder().encode("shanky@123")) .roles("USER") .build();
  
  UserDetails adminUser = User.withUsername("shashank")
  .password(passwordEncoder().encode("shashank@123")) .roles("ADMIN") .build();
  
  return new InMemoryUserDetailsManager(normalUser,adminUser); }
  
  
  
  @Bean public SecurityFilterChain customFilterChain(HttpSecurity http) throws
  Exception {
  
  http.csrf().disable() .authorizeHttpRequests() .requestMatchers("/api/admin")
  .hasRole("ADMIN") .requestMatchers("/api/user") .hasRole("USER")
  .requestMatchers("/api/normal") .permitAll() .anyRequest() .authenticated()
  .and() .formLogin();
  
  
  return http.build();
  
  
  }
  
  
  }
 