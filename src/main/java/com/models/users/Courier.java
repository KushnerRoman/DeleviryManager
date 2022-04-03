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
	public List<Delivery> deliveries;
	
	
	public Courier () {
		this.deliveries=new ArrayList<Delivery>();	
		role=UserTypeUtils.COURIER;
		this.onlineStatus=false;
	}


	public Courier (String firstName,String lastName,String login ) {
		this.deliveries=new ArrayList<Delivery>();
		this.role=UserTypeUtils.COURIER;
		this.firstName=firstName;
		this.lastName=lastName;
		this.login=login;
		this.onlineStatus=false;
		
	}


	public List<Delivery> getDeliveries() {
		return deliveries;
	}


	public void setDeliveries(List<Delivery> deliveries) {
		this.deliveries = deliveries;
	}

	public void addDelivery(Delivery delivery) {
		this.deliveries.add(delivery);
	}
	public void deleteDelivery(Delivery delivery) {
		this.deliveries.remove(delivery);
	}
	
	
	
	
}
