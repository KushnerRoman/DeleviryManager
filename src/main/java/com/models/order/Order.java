package com.models.order;

import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public  class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	protected long id;
	
	@Column(nullable = false)
	@ApiModelProperty( value=" Min=1 Max=255 " )
	protected String customerName;
	
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
	@Override
	public int hashCode() {
		return Objects.hash(customerName, orderDate, orderTime, price);
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
		return Objects.equals(customerName, other.customerName) && Objects.equals(orderDate, other.orderDate)
				&& Objects.equals(orderTime, other.orderTime)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price);
	}
	
	
}
