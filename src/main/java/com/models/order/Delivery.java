package com.models.order;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.models.users.Courier;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "deliveries")
public class Delivery extends Order implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8094226237592643559L;

	private String city;
	
	private String street;
	
	private String streetNum;
	
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = Courier.class)
	@JoinTable(name="courier_vs_delivery",joinColumns = @JoinColumn(name="delivery_id"),inverseJoinColumns = @JoinColumn(name="courier_id"))
	@JsonBackReference
	public long courierId;
	
	public Delivery() {
		
	}


	public Delivery(String city, String street, String streetNum,Date orderDate,Time orderTime) {
		this.orderDate=orderDate;
		this.orderTime=orderTime;
		this.city = city;
		this.street = street;
		this.streetNum = streetNum;
	}
	


	@Override
	public String toString() {
		return "Delivery [city=" + city + ", street=" + street + ", streetNum=" + streetNum + ", id=" + id
				+ ", customerName=" + customerName + ", price=" + price + ", orderDate=" + orderDate + ", orderTime="
				+ orderTime + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(city, courierId, street, streetNum);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Delivery other = (Delivery) obj;
		return Objects.equals(city, other.city) && courierId == other.courierId && Objects.equals(street, other.street)
				&& Objects.equals(streetNum, other.streetNum);
	}
	

	
	
	
}
