package com.christian_gonzalez_socialmedia_capstone.models;

import java.time.LocalDate;
// import java.util.Date;
import java.util.Collection;

import javax.persistence.*;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
// import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name="users")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private long userId;
	private String username;
	private String password;
	private LocalDate createdOn;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "userid"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
	private Collection<Role> roles;
	
	// constructors
	public User () {
		
	}
	
	public User(long userId, String username, String password, LocalDate createdOn) {

		this.userId = userId;
		this.username = username;
		this.password = password;
		this.createdOn = createdOn;
	}

	public User(String username, String password, LocalDate createdOn) {
		this.username = username;
		this.password = password;
		this.createdOn = createdOn;
	}

	// getters and setters
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}
	
	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId 
				+ ", username=" + username 
				+ ", password=" + password 
				+ ", createdOn=" + createdOn + "]";
	}
	
	
	
}
