package in.com.securityconfig;

import static org.springframework.security.config.Customizer.withDefaults;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    public DataSource dataSource;
    
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
    
    	this.dataSource=dataSource;
    	
        JdbcUserDetailsManager detailsManager = new JdbcUserDetailsManager(dataSource);
                UserDetails user = User
                .withUsername("aditya")
//                .password(new BCryptPasswordEncoder().encode("aditya@123"))
                .password("$2a$12$q8tAoLxD556CAbroRmKAWuf4haEggEKkHhObXfHiYheIplrrm.AN.")
                .roles("ADMIN")
                .build();
        
        UserDetails user1 = User
                .withUsername("sameer")
//               .password(new BCryptPasswordEncoder().encode("sameer@123"))
                .password("$2a$12$iH4IYGD4QFc6LVkQI6Ky7eAtfkyvwiEFajKSsd43CBzxBbAeI/l4.")
               .roles("USER")
               .build();       
       detailsManager.createUser(user);
       detailsManager.createUser(user1);
		return detailsManager;
   }

    @Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception
	{
	
		auth.jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder())
		.dataSource(dataSource);
        	
	}

	@Bean
   SecurityFilterChain customFilterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/bank/balance")
                        .hasRole("ADMIN")
                        .requestMatchers("/bank/show")
                        .hasRole("USER")
                        .requestMatchers("/bank/home")
                        .permitAll()
                        .anyRequest()
                        .authenticated())
                .formLogin(withDefaults());
		
		return http.build();
    }
   

    }



