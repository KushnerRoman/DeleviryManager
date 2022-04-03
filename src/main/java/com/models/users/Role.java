package com.models.users;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.NaturalId;

import com.utils.ServiceUtils.UserTypeUtils;

public class Role implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7220885601749791236L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Enumerated
	@NaturalId
	@Column
	private UserTypeUtils role;

	public Role() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserTypeUtils getRole() {
		return role;
	}

	public void setRole(UserTypeUtils role) {
		this.role = role;
	}
	
	
	
	

}
