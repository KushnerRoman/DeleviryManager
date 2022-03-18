package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controller.api.StoreManagerApi;
import com.exceptions.courierExceptions.CourierExistsException;
import com.models.users.Courier;
import com.services.userImpl.StoreManager;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/StoreManager")
public class StoreManagerContoller implements StoreManagerApi {
	
	@Autowired
	StoreManager managerServie;

	@Override
	public ResponseEntity<?> createCourier(Courier newCourier) {
		
			try {
				return new ResponseEntity<Courier>(managerServie.addNewCourier(newCourier),HttpStatus.OK);
			} catch (CourierExistsException e) {
				return new ResponseEntity<String>("Error Blat", HttpStatus.BAD_REQUEST);
			}
		
	

	}	

	
	
	

}
