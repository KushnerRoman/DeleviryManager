package com.services.userImpl;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exceptions.courierExceptions.CourierExistsException;
import com.exceptions.courierExceptions.CourierNotExistsException;
import com.exceptions.deliveryExceptions.DeliveryNotExistException;
import com.exceptions.orderExceptions.DeliveryExistException;
import com.exceptions.orderExceptions.OrderNotExistException;
import com.models.order.Delivery;
import com.models.order.Order;
import com.models.users.Courier;
import com.repository.CourierRepository;
import com.repository.DeliveryRepository;
import com.repository.OrderRepository;
import com.repository.StoreManagerRepository;
import com.services.userInterface.StoreManagerInf;
import com.utils.ServiceUtils.DateAndTimeUtils;

@Service
public class StoreManagerService implements StoreManagerInf {

	@Autowired
	CourierRepository courierRepo;
	@Autowired
	DeliveryRepository deliveryRepo;
	@Autowired
	OrderRepository orderRepo;
	@Autowired
	StoreManagerRepository managerRepo;
	
	@Override
	public boolean existsCourierByLogin(String email) {

		return courierRepo.findByUsernameIgnoreCase(email).isPresent();
	}

	@Override
	public boolean existsCourierById(Long id) {
		return deliveryRepo.existsById(id);
	}

	

	@Override
	public boolean existsDelivery(Delivery delivery) {
		
		Optional<Long> opDeliveryId=(Optional<Long>) Optional.of(delivery.getId());
		
		if(opDeliveryId.isPresent()) return deliveryRepo.existsById(opDeliveryId.get());
		
		return false;
	}
	

	@Override
	public boolean existsDeliveryById(Long id) {
	
		
		return deliveryRepo.existsById(id);
	}

	@Override
	public List<Delivery> getAllCouriers() {
		
		return deliveryRepo.findAll();
	}

	@Override
	public Optional<List<Delivery>> getAllDeliveries() {
		
		
		
		return Optional.of(deliveryRepo.findAll());
	}

	@Override
	public Courier addNewCourier(Courier couirer) throws CourierExistsException {
		if(!existsCourierByLogin(couirer.getUsername())) {
			courierRepo.saveAndFlush(couirer);
			return couirer;
		}else {
			throw new CourierExistsException("Courier with this login already exist");
		}

		
		

	}


	@Override
	public Delivery addNewDelivery(Delivery delivery) throws DeliveryExistException {
		

			Time lastOrder = null;
				try {
					lastOrder = getTodayLastOrder(delivery.getPhoneNumber());
					System.out.println(lastOrder.toString());
				} catch (DeliveryNotExistException e) {
					System.out.println(e.getMessage());
					deliveryRepo.save(delivery);					
				}
					if(checkValidityOrderTime(lastOrder)) {
						deliveryRepo.save(delivery);
					}else {
						throw new DeliveryExistException("try in few minutes again ");
					}
	
		return delivery;
	
		
		
		
		
	}

	@Override
	public void editCourier(Courier courier) throws CourierNotExistsException {
		

	}

	@Override
	public void editDelivery(Order order) throws OrderNotExistException {


	}

	@Override
	public Optional<Courier> getOneCourierById(Long courierId) throws CourierNotExistsException {
		
		return null;
	}

	@Override
	public Optional<Order> getOneDeliveryById(Long orderId) throws OrderNotExistException {
	
		return null;
	}

	@Override
	public boolean existsUser(Long id) {
		if(id!=null) {
			if(managerRepo.existsById(id)) {
				return true ;
			}
			else if(courierRepo.existsById(id)) {
				return true;
			}else {
				return false;
			}
		}else {
			return false ;
		}
		
		

	}

	@Override
	public Time getTodayLastOrder(String phoneNumber) throws DeliveryNotExistException {
	
		
		
		return deliveryRepo.getLastTodayOrderTimeByPhone(Date.valueOf(DateAndTimeUtils.getCurrentDate()), phoneNumber)
				.orElseThrow(()-> new DeliveryNotExistException("Customer :"+phoneNumber+" does not have orders today" ));
	
	}
	
	public boolean checkValidityOrderTime(Time timeToCheck) {
		
		return DateAndTimeUtils.checkFiveMinutesTimeOutOrder(timeToCheck);
		
	}




}
