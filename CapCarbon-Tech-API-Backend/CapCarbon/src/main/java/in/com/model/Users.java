package in.com.model;

import java.util.List;


import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Component
@Entity
@Data
@Table(name = "users")
public class Users {
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Integer userId;
	
	private String username;
	private String password;
	private boolean disabled;
	private boolean accountExpired;
	private boolean accountLocked;
	private boolean credentialsExpired;

	
	@JsonIgnore
	//@ElementCollection(fetch = FetchType.EAGER)
	//@CollectionTable(name = "",joinColumns = @JoinColumn(name="",referencedColumnName = ""))
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(name = "user_role", 
		joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "userId"), 
		inverseJoinColumns =@JoinColumn(name = "role_id",referencedColumnName = "roleId"))
	public List<Role> roles;
	
}