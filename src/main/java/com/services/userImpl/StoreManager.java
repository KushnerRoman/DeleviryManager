package com.services.userImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exceptions.courierExceptions.CourierExistsException;
import com.exceptions.courierExceptions.CourierNotExistsException;
import com.exceptions.orderExceptions.OrderExistException;
import com.exceptions.orderExceptions.OrderNotExistException;
import com.models.order.Delivery;
import com.models.order.Order;
import com.models.users.Courier;
import com.repository.CourierRepository;
import com.repository.DeliveryRepository;
import com.services.userInterface.StoreManagerInf;

@Service
public class StoreManager implements StoreManagerInf {

	@Autowired
	CourierRepository courierRepo;
	@Autowired
	DeliveryRepository deliveryRepo;
	
	@Override
	public boolean isExistsCourierByEmail(String email) {

		
		return courierRepo.findByEmailIgnoreCase(email).isPresent();
	}

	@Override
	public boolean isExistsCourierById(long id) {
		if(deliveryRepo.existsById(id))return true;
		return false;
	}

	@Override
	public boolean isExistsOrder(Order order) {
		
		return false;
	}

	@Override
	public boolean isExistsDelivery(Delivery delivery) {
		
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
	public void addNewCourier(Courier couirer) throws CourierExistsException {
		

	}

	@Override
	public void addNewOrder(Order order) throws OrderExistException {
		

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
