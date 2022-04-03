package com.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.models.users.StoreManager;
import com.models.users.User;

@Repository
@EnableJpaRepositories
public interface StoreManagerRepository extends JpaRepository<StoreManager, Long> {
	
	
	public Optional<User>findByLoginIgnoreCase(String login);
	
	

}
