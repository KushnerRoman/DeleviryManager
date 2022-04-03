package com.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exceptions.courierExceptions.CourierExistsException;
import com.exceptions.orderExceptions.DeliveryExistException;
import com.exceptions.userExceptions.UserNotExistException;
import com.models.order.Delivery;
import com.models.users.Courier;
import com.utils.ApiResponseAnnotations.DefaultApiResponses;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/StoreManagerService")
public interface StoreManagerApi {

	
	@ApiOperation(value="Create new Courier")
	@DefaultApiResponses
	@PostMapping(value ="/create-courier", produces="application/json")
	public ResponseEntity<?> createCourier(@RequestBody Courier newCourier  ) throws CourierExistsException;
	
	@ApiOperation(value="check if user exist by id")
	@DefaultApiResponses
	@GetMapping(value ="/checkUser")
	public ResponseEntity<?> userAppIdCheck(@RequestParam("userId") long userId) throws UserNotExistException ;
	
	@ApiOperation(value="Create new Delivery")
	@DefaultApiResponses
	@PostMapping(value ="/create-delivery", produces="application/json")
	public ResponseEntity<?>createDeliveryOrder(@RequestBody Delivery newDelivery) throws DeliveryExistException;

}
