package com.springSecurity.userService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.models.users.User;
import com.repository.CourierRepository;
@Component
public class UserDetailsServiceImp implements UserDetailsService {

	
	@Autowired(required = true)
	private CourierRepository courierRepo; 
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		if(courierRepo.findByEmailIgnoreCase(username).isPresent()) {
			User user = courierRepo.findByEmailIgnoreCase(username).get();
			return UserPrinciple.build(user);
		}
		
		
		return null;
	}

}
