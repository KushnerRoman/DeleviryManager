package com.controller.api;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.message.request.loginRequest.LoginForm;
import com.utils.ApiResponseAnnotations.DefaultApiResponses;

import io.swagger.annotations.ApiOperation;



@RestController
@CrossOrigin(origins ="*" ,maxAge=3600)
@RequestMapping("/api/auth")
public interface AuthControllerApi {

	
	@ApiOperation(value="Create new Courier")
	@DefaultApiResponses
	@PostMapping(value ="/store-login", produces="application/json")	
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest);
	
	
}
