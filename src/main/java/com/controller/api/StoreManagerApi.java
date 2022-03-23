package com.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.exceptions.courierExceptions.CourierExistsException;
import com.exceptions.orderExceptions.DeliveryExistException;
import com.exceptions.orderExceptions.OrderExistException;
import com.models.order.Delivery;
import com.models.order.Order;
import com.models.users.Courier;
import com.utils.ApiResponseAnnotations.DefaultApiResponses;

import io.swagger.annotations.ApiOperation;

public interface StoreManagerApi {

	
	@ApiOperation(value="Create new Courier")
	@DefaultApiResponses
	@PostMapping(value ="/create-courier", produces="application/json")
	public ResponseEntity<?> createCourier(@RequestBody Courier newCourier  ) throws CourierExistsException;
	
	@ApiOperation(value="Create new Order")
	@DefaultApiResponses
	@PostMapping(value ="/create-order", produces="application/json")
	public ResponseEntity<?> createOrder(@RequestBody Order newOrder) throws OrderExistException;
	
	@ApiOperation(value="Create new Delivery")
	@DefaultApiResponses
	@PostMapping(value ="/create-delivery", produces="application/json")
	public ResponseEntity<?>createDeliveryOrder(@RequestBody Delivery newDelivery) throws DeliveryExistException;

}
