package com.models.order;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.models.users.Courier;

import io.swagger.annotations.ApiModelProperty;
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


	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	protected long id;
	@Column
	@ApiModelProperty(value="city name")
	private String city;
	@Column
	@ApiModelProperty(value="street name")
	private String street;
	@Column
	@ApiModelProperty(value="house number number name")
	private String streetNum;
	
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = Courier.class ,optional = true)
	@JoinTable(name="courier_vs_delivery",joinColumns = @JoinColumn(name="delivery_id"),inverseJoinColumns = @JoinColumn(name="courier_id"))
	@JsonBackReference
	public long courierId;
	
	public Delivery() {
		
	}


	public Delivery(String city, String street, String streetNum,Date orderDate,Time orderTime,double price,String customerName) {
		this.orderDate=orderDate;
		this.orderTime=orderTime;
		this.city = city;
		this.street = street;
		this.streetNum = streetNum;
		this.price=price;
		this.customerName=customerName;
	}
	




	

	
	
	
}
