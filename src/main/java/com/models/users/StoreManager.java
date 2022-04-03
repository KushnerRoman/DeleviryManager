package com.models.users;

import java.io.Serializable;

import javax.persistence.Column;
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
		role=UserTypeUtils.STORE_MANAGER;
		onlineStatus=false;
	}
	
	public StoreManager(String firstName,String lastName,String username,String password) {
		role=UserTypeUtils.STORE_MANAGER;
		this.firstName=firstName;
		this.lastName=lastName;
		this.username=username;
		this.password=password;
		onlineStatus=false;
		
	}


	

}
