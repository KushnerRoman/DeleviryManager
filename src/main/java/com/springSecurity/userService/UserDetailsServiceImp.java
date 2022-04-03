package com.springSecurity.userService;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.models.users.StoreManager;
import com.models.users.User;
import com.repository.CourierRepository;
import com.repository.StoreManagerRepository;
@Component
public class UserDetailsServiceImp implements UserDetailsService {

	
	@Autowired(required = true)
	private CourierRepository courierRepo; 
	
	@Autowired(required = true)
	private StoreManagerRepository managerRepo; 
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		
		if(courierRepo.findByUsernameIgnoreCase(login).isPresent()) {
			User user = courierRepo.findByUsernameIgnoreCase(login).get();
			return UserPrinciple.build(user);
		}else if(managerRepo.findByUsernameIgnoreCase(login).isPresent()) {
			User user = managerRepo.findByUsernameIgnoreCase(login).get();
			System.out.println(user.toString());
			return UserPrinciple.build(user);
		}
		
		
		return (UserDetails) new LoginException("Error Login " + login);
	}

}
