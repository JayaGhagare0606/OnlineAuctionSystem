package com.online.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online.model.Seller;

public interface SellerRepository extends JpaRepository<Seller, Integer>{
	
	public Seller findByEmail(String email);
	
	public Seller findByEmailAndPassword(String email, String password);

}
