package com.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.controller.api.AuthControllerApi;
import com.message.request.loginRequest.LoginForm;
import com.message.responses.JwtResponse;
import com.springSecurity.jwt.JwtProvider;
import com.springSecurity.userService.UserPrinciple;
import com.utils.ApiResponseAnnotations.DefaultApiResponses;
import com.utils.ServiceUtils.UserTypeUtils;

import io.swagger.annotations.ApiOperation;




@RestController
@CrossOrigin(origins ="*" ,maxAge=3600)
@RequestMapping("/api/auth")
public class AuthController {
	
	
	@Autowired
	AuthenticationManager authManager;
	
	
	@Autowired
	private JwtProvider jwtProvider;

	@ApiOperation(value="Login")
	@DefaultApiResponses
	@PostMapping(value ="/storeLogin" ,produces = "application/json")	

	public ResponseEntity<?> authenticateUser( @Valid @RequestBody LoginForm loginRequest ) {
		
		
		
		Authentication authentication=authManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		
			SecurityContextHolder.getContext().setAuthentication(authentication);

			String jwt=jwtProvider.generateJwtToken(authentication);
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			
			UserPrinciple userPrinciple= (UserPrinciple) authentication.getPrincipal();
			
			UserTypeUtils role=UserTypeUtils.STORE_MANAGER;
			
			Collection<? extends GrantedAuthority> authorities =null;
			
			switch (role) {
			case CUSTOMER:
				if(userPrinciple.getAuthorities().contains(new SimpleGrantedAuthority(UserTypeUtils.CUSTOMER.name()))) {
					authorities =new ArrayList<>(Arrays.asList(new SimpleGrantedAuthority(UserTypeUtils.CUSTOMER.name())));
					}
				break;
			case STORE_MANAGER:
				if(userPrinciple.getAuthorities().contains(new SimpleGrantedAuthority(UserTypeUtils.STORE_MANAGER.name()))) {
					authorities =new ArrayList<>(Arrays.asList(new SimpleGrantedAuthority(UserTypeUtils.STORE_MANAGER.name())));
					}	
				break;
			case SHIFT_MANAGER:
				if(userPrinciple.getAuthorities().contains(new SimpleGrantedAuthority(UserTypeUtils.SHIFT_MANAGER.name()))) {
					authorities =new ArrayList<>(Arrays.asList(new SimpleGrantedAuthority(UserTypeUtils.SHIFT_MANAGER.name())));
					}
				break;

			default:
				break;
			}
			
			return ResponseEntity.ok(new JwtResponse(jwt, userPrinciple.getUsername(), authorities));
	}

}
