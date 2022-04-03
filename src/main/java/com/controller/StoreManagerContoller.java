package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controller.api.StoreManagerApi;
import com.exceptions.courierExceptions.CourierExistsException;

import com.exceptions.orderExceptions.DeliveryExistException;

import com.exceptions.userExceptions.UserNotExistException;
import com.models.order.Delivery;
import com.models.users.Courier;
import com.services.userImpl.StoreManagerService;


public class StoreManagerContoller implements StoreManagerApi {
	
	@Autowired
	StoreManagerService managerServie;

	@Override
	public ResponseEntity<?> createCourier(Courier newCourier) {
		
			try {
				return new ResponseEntity<Courier>(managerServie.addNewCourier(newCourier),HttpStatus.OK);
			} catch (CourierExistsException e) {
				return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
			}
		
	

	}



	@Override
	public ResponseEntity<?> createDeliveryOrder(Delivery newDelivery)  {
		
		System.out.println(newDelivery);
		if(managerServie.existsUser(newDelivery.getUserId())) {
			
			System.out.println(newDelivery);
				try {
					return new ResponseEntity<Delivery>(managerServie.addNewDelivery(newDelivery),HttpStatus.OK);
				}catch (DeliveryExistException e) {
					return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
				
				}
		}else {
			return new ResponseEntity<String>("Error !Cannot take order!"
					+ " Reason: User by id :"+newDelivery.getUserId()+" is not exist" ,HttpStatus.BAD_REQUEST);	
			}
	}

	@Override
	public ResponseEntity<?> userAppIdCheck(long userId) throws UserNotExistException {
		
		
		
		
		return null;
	}	
	
	

	
	
	

}
