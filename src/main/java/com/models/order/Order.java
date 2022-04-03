package com.models.order;


import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.utils.ServiceUtils.OrderTypeUtils;

import java.sql.Time;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


import io.swagger.annotations.ApiModelProperty;




@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract  class Order  {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@JsonIgnore
	public Long id;
	
	@Column(name="User_Worker_ID")
	@ApiModelProperty( value=" The id of the User who took the order " )
	public Long userId;
	
	@Column(nullable = false)
	@ApiModelProperty( value=" Min=1 Max=255 " )
	public String customerName;
	
	@Column(nullable = false)
	@ApiModelProperty(value="the phone number of the customer as String ")
	public String phoneNumber;
	
	@Column(nullable = false )
	@ApiModelProperty( value=" Min=1 Max=9999 " )
	public double price;
	
	@Column(nullable = false)
	@ApiModelProperty(example = "yyyy-mm-dd")
	public Date orderDate;
	
	@Column(nullable = false)
	@ApiModelProperty(example = "hh:mm:ss hour - 0 to 23\r\n"
			+ "minute - 0 to 59\r\n"
			+ "second - 0 to 59")
	public Time orderTime;


	@Enumerated(EnumType.STRING)
	@Column(nullable = true)
	public OrderTypeUtils orderType;

	public Order(){};

	public Long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Time getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Time orderTime) {
		this.orderTime = orderTime;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public OrderTypeUtils getOrderType() {
		return orderType;
	}
	public void setOrderType(OrderTypeUtils orderType) {
		this.orderType = orderType;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}



	@Override
	public int hashCode() {
		return Objects.hash(customerName, orderTime);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(customerName, other.customerName) && Objects.equals(orderTime, other.orderTime);
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", userId=" + userId + ", customerName=" + customerName + ", phoneNumber="
				+ phoneNumber + ", price=" + price + ", orderDate=" + orderDate + ", orderTime=" + orderTime
				+ ", orderType=" + orderType + "]";
	}



	
	
}
