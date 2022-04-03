package com.repository;



import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.models.order.Delivery;
@Repository
@EnableJpaRepositories

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {

	List<Delivery> findAllByPhoneNumberAndOrderDate(String phoneNumber, Date orderDate);

	
	@Query("SELECT  max(d.orderTime) from Delivery d where  d.orderDate=?1 and d.phoneNumber=?2  ")
	public Optional<Time> getLastTodayOrderTimeByPhone(Date date,String phoneNumber);
	
	public List<Delivery> findAllByPhoneNumber(String phoneNumber);
	
	
}
