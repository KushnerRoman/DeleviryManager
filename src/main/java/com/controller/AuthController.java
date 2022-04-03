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

import com.controller.api.AuthControllerApi;
import com.message.request.loginRequest.LoginForm;
import com.message.responses.JwtResponse;
import com.springSecurity.jwt.JwtProvider;
import com.springSecurity.userService.UserPrinciple;
import com.utils.ServiceUtils.UserTypeUtils;




public class AuthController implements AuthControllerApi {
	
	
	@Autowired
	AuthenticationManager authManager;
	
	
	@Autowired
	private JwtProvider jwtProvider;

	@Override
	public ResponseEntity<?> authenticateUser(@Valid LoginForm loginRequest) {
		
		Authentication authentication=authManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		
			SecurityContextHolder.getContext().setAuthentication(authentication);

			String jwt=jwtProvider.generateJwtToken(authentication);
			
			UserPrinciple userPrinciple= (UserPrinciple) authentication.getPrincipal();
			
			UserTypeUtils role=loginRequest.getRole();
			
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
