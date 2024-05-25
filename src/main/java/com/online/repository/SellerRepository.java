package com.online.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online.model.Seller;

public interface SellerRepository extends JpaRepository<Seller, Integer>{
	

	public Seller findByEmailAndPassword(String email, String password);
	
	public List<Seller> findByEmail(String email);

}
