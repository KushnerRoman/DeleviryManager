package com.repository;

import java.util.List;


import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.models.order.Order;
@Repository
@EnableJpaRepositories
public interface OrderRepository extends JpaRepository<Order, Long> {
	
	List<Order> findAll();
	
	

}
