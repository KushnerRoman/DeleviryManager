package com.models.order;

import java.sql.Date;
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

import com.utils.ServiceUtils.OrderTypeUtils;

import io.swagger.annotations.ApiModelProperty;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract  class Order  {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	protected long id;
	
	@Column(nullable = false)
	@ApiModelProperty( value=" Min=1 Max=255 " )
	protected String customerName;
	
	@Column
	@ApiModelProperty(value="the phone number of the customer as String ")
	protected String phoneNumber;
	
	@Column(nullable = false )
	@ApiModelProperty( value=" Min=1 Max=9999 " )
	protected double price;
	
	@Column(nullable = false)
	@ApiModelProperty(example = "yyyy-mm-dd")
	protected Date orderDate;
	@Column(nullable = false)
	@ApiModelProperty(example = "hh:mm:ss hour - 0 to 23\r\n"
			+ "minute - 0 to 59\r\n"
			+ "second - 0 to 59")
	protected Time orderTime;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	protected OrderTypeUtils orderType;

	public long getId() {
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
	@Override
	public int hashCode() {
		return Objects.hash(customerName, id, orderDate, orderTime, orderType, phoneNumber, price);
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
		return Objects.equals(customerName, other.customerName) && id == other.id
				&& Objects.equals(orderDate, other.orderDate) && Objects.equals(orderTime, other.orderTime)
				&& orderType == other.orderType && Objects.equals(phoneNumber, other.phoneNumber)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price);
	}

	
	
}
