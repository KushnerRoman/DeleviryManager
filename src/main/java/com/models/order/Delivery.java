package com.models.order;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.models.users.Courier;
import com.utils.ServiceUtils.OrderTypeUtils;

import io.swagger.annotations.ApiModelProperty;




@Entity
@Table(name = "deliveries")
public class Delivery extends Order implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8094226237592643559L;

	@Column
	@ApiModelProperty(value="city name")
	private String city;
	@Column
	@ApiModelProperty(value="street name")
	private String street;
	@Column
	@ApiModelProperty(value="house number ")
	private String houseNum;
	
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = Courier.class ,fetch = FetchType.LAZY)
	@JoinTable(name="courier_vs_delivery",joinColumns = @JoinColumn(name="delivery_id"),inverseJoinColumns = @JoinColumn(name="courier_id"))
	@JsonBackReference
	@JsonIgnore
	public Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	public OrderTypeUtils orderType;
	
	public Delivery() {
		this.orderType=OrderTypeUtils.DELIVERY;
	}


	public Delivery(String city, String street, String houseNum,Date orderDate,Time orderTime,double price,String customerName,String phoneNumber) {
		this.orderType=OrderTypeUtils.DELIVERY;
		this.orderDate=orderDate;
		this.orderTime=orderTime;
		this.city = city;
		this.street = street;
		this.houseNum = houseNum;
		this.price=price;
		this.customerName=customerName;
		this.phoneNumber=phoneNumber;
	}



	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}




	public String getHouseNum() {
		return houseNum;
	}


	public void setHouseNum(String houseNum) {
		this.houseNum = houseNum;
	}




	public OrderTypeUtils getOrderType() {
		return orderType;
	}


	public void setOrderType(OrderTypeUtils orderType) {
		this.orderType = orderType;
	}




	@Override
	public String toString() {
		return "Delivery [city=" + city + ", street=" + street + ", houseNum=" + houseNum + ", id=" + id
				+ ", orderType=" + orderType + ", userId=" + userId + ", customerName=" + customerName
				+ ", phoneNumber=" + phoneNumber + ", price=" + price + ", orderDate=" + orderDate + ", orderTime="
				+ orderTime + "]";
	}



	

	
	
	
}
