package com.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.exceptions.courierExceptions.CourierExistsException;
import com.models.users.Courier;
import com.utils.ApiResponseAnnotations.DefaultApiResponses;

import io.swagger.annotations.ApiOperation;

public interface StoreManagerApi {

	
	@ApiOperation(value="Create new Courier")
	@DefaultApiResponses
	@PostMapping(value ="/create-courier", produces="application/json")
	public ResponseEntity<?> createCourier(@RequestBody Courier newCourier  ) throws CourierExistsException;
	
}
