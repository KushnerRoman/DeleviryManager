package com.models.users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.utils.ServiceUtils.UserTypeUtils;

import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;






@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract  class User {
	

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public Long id;
	
	
	
	@Column(nullable = false ,unique = true)
	public String username;	
	
	@Column(nullable = false)
	public String password;
	
	@Column(nullable = false ,unique = false)
	@ApiModelProperty(value = "Min=1, Max=12 ")
	public String firstName;
	
	@Column(nullable = false ,unique = false)
	@ApiModelProperty(value = "Min=1, Max=15 ")
	public String lastName;
	
	@Column(nullable = false)
	@ApiModelProperty( value="online status 1 - online 0 - offline")
	public boolean onlineStatus;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	public UserTypeUtils role;
	
	public User() {
		
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public UserTypeUtils getRole() {
		return role;
	}
	public void setRole(UserTypeUtils role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String login) {
		this.username = login;
	}

	public boolean isOnlineStatus() {
		return onlineStatus;
	}

	public void setOnlineStatus(boolean onlineStatus) {
		this.onlineStatus = onlineStatus;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", Username=" + username + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", onlineStatus=" + onlineStatus + ", role=" + role + "]";
	}



	
	
}
