package com.models.users;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.utils.ServiceUtils.UserTypeUtils;

@Entity
@Table(name="StoreManager")
public class StoreManager extends User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5187636367002263857L;

	public StoreManager() {

	}
	
	public StoreManager(String firstName,String lastName,String email,String password) {
		this.role=UserTypeUtils.STORE_MANAGER;
		this.firstName=firstName;
		this.lastName=lastName;
		this.email=email;
		this.password=password;
		
	}
	

}
