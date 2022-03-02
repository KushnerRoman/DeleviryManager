package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.models.order.Delivery;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {

//	public List<Delivery> getAllDeliveries();
	
}
