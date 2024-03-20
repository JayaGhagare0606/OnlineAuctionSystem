package com.online.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online.model.Buyer;

public interface BuyerRepository extends JpaRepository<Buyer, Integer>{
	
	public Buyer findByEmail(String email);
	
	public Buyer findByEmailAndPassword(String email, String password);

}
