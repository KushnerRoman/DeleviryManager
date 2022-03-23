package com.services.userImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exceptions.courierExceptions.CourierExistsException;
import com.exceptions.courierExceptions.CourierNotExistsException;
import com.exceptions.orderExceptions.DeliveryExistException;
import com.exceptions.orderExceptions.OrderExistException;
import com.exceptions.orderExceptions.OrderNotExistException;
import com.models.order.Delivery;
import com.models.order.Order;
import com.models.users.Courier;
import com.repository.CourierRepository;
import com.repository.DeliveryRepository;
import com.repository.OrderRepository;
import com.services.userInterface.StoreManagerInf;

@Service
public class StoreManagerService implements StoreManagerInf {

	@Autowired
	CourierRepository courierRepo;
	@Autowired
	DeliveryRepository deliveryRepo;
	@Autowired
	OrderRepository orderRepo;
	
	@Override
	public boolean isExistsCourierByEmail(String email) {

		return courierRepo.findByEmailIgnoreCase(email).isPresent();
	}

	@Override
	public boolean isExistsCourierById(long id) {
		return deliveryRepo.existsById(id);
	}

	@Override
	public boolean isExistsOrder(Order order) {
		
		Optional<Long> opOrderId=Optional.of(order.getId());

		if(opOrderId.isPresent()) return orderRepo.existsById(opOrderId.get());
		  
		return false ;
	}

	@Override
	public boolean isExistsDelivery(Delivery delivery) {
		
		Optional<Long> opDeliveryId=(Optional<Long>) Optional.of(delivery.getId());
		
		if(opDeliveryId.isPresent()) return deliveryRepo.existsById(opDeliveryId.get());
		
		return false;
	}
	

	@Override
	public boolean isExistsOrderById(long id) {
	
		return false;
	}

	@Override
	public Optional<Courier> getAllCouriers() {
		
		return null;
	}

	@Override
	public Optional<Order> getAllOrders() {
		
		
		
		return null;
	}

	@Override
	public Courier addNewCourier(Courier couirer) throws CourierExistsException {
		if(!isExistsCourierByEmail(couirer.getEmail())) {
			courierRepo.saveAndFlush(couirer);
			return couirer;
		}else {
			throw new CourierExistsException("Courier by those values already exist");
		}

		
		

	}

	@Override
	public Order addNewOrder(Order order) throws OrderExistException {
		
		if(!isExistsOrder(order)) {
			orderRepo.saveAndFlush(order);
			return order;
		}else {
			throw new OrderExistException("Order by already exist");
		}
		

	}
	@Override
	public Delivery addNewDelivery(Delivery delivery) throws DeliveryExistException {
	
		if(!isExistsDelivery(delivery)) {
			deliveryRepo.saveAndFlush(delivery);
			return delivery;
			
		}else {
			throw new DeliveryExistException("Delivery already exist");
		}		
	}
	
	

	@Override
	public void editCourier(Courier courier) throws CourierNotExistsException {
		

	}

	@Override
	public void editOrder(Order order) throws OrderNotExistException {


	}

	@Override
	public Optional<Courier> getOneCourierById(long courierId) throws CourierNotExistsException {
		
		return null;
	}

	@Override
	public Optional<Order> getOneOrderById(long orderId) throws OrderNotExistException {
	
		return null;
	}




}
