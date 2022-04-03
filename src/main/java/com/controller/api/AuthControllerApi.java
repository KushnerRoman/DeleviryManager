package com.controller.api;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.message.request.loginRequest.LoginForm;




public interface AuthControllerApi {

	
		
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest);
	
	
}
