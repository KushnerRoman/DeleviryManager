package com.models.users;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.models.order.Order;
import com.utils.ServiceUtils.UserTypeUtils;


@Entity
@Table(name = "customers")
public class Customer extends User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2736277410124647393L;
	
	@Column(nullable = false)
	public String email;

	@Column(nullable =false)
	public String password;
	
	@Column(nullable=false)
	public String phoneNumber;
	
	public Customer() {
		this.role=UserTypeUtils.CUSTOMER;
	}
	

	public Customer(String email, String password,String firstName,String lastName,String phoneNumber) {
		this.email = email;
		this.password = password;
		this.firstName=firstName;
		this.lastName=lastName;
		this.phoneNumber=phoneNumber;
		this.role=UserTypeUtils.CUSTOMER;
		
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(email, password, phoneNumber);
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(email, other.email) && Objects.equals(password, other.password)
				&& Objects.equals(phoneNumber, other.phoneNumber);
	}


	@Override
	public String toString() {
		return "Customer [email=" + email + ", password=" + password + ", phoneNumber=" + phoneNumber + "]";
	}
	
	

  
	
	
	
}
