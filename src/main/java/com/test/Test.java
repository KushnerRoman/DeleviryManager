package com.test;




import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import com.models.users.StoreManager;
import com.repository.StoreManagerRepository;





@Service
public class Test {

	@Autowired
	StoreManagerRepository service;
	
	 @Autowired
	 private PasswordEncoder encoder;
	
	public Test() {

		
	}
	
	@PostConstruct
	public void startTest() {
	
		
	
			if (service.count()==0) {
				StoreManager adminManager= new  StoreManager("roman","kushner","admin",encoder.encode("admin"));
				service.saveAndFlush(adminManager);
				
			}
		
		
	}
	

	
	

}
