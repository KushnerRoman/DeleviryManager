package com.models.users;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.models.order.Delivery;
import com.utils.ServiceUtils.UserTypeUtils;




@Entity
@Table(name = "Couriers")

public class Courier extends User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7457146611287662529L;
	@OneToMany
	@JoinTable(name="courier_vs_delivery", joinColumns = @JoinColumn(name="courier_id"),inverseJoinColumns = @JoinColumn(name="delivery_id"))
	private List<Delivery> deliveries;

	public Courier () {
		
	}


	public Courier (String firstName,String lastName,String email,String password ) {
		deliveries=new ArrayList<Delivery>();
		this.role=UserTypeUtils.COURIER;
		this.firstName=firstName;
		this.lastName=lastName;
		this.email=email;
		this.password=password;
		
	}


	public List<Delivery> getDeliveries() {
		return deliveries;
	}


	public void setDeliveries(List<Delivery> deliveries) {
		this.deliveries = deliveries;
	}

	
	
	
	
}
