package com.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.models.users.Courier;

@Repository
@EnableJpaRepositories
public interface CourierRepository extends JpaRepository<Courier, Long> {





	public Optional<Courier> findByUsernameIgnoreCase(String username);
	
	
	
	
	
}
