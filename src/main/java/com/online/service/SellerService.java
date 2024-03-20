package com.online.service;

import java.util.List;

import com.online.model.Seller;

public interface SellerService {
	
	public List<Seller> sellerList();
	
	public String saveSeller(Seller seller);
	
	public Seller findSellerById(int id);
	
	public String updateSeller(Seller seller, int id);
	
	public String deleteSeller(int id);
	
	public Seller findByEmail(String email);
	
	public Seller findByEmailAndPassword(String email, String password);

}
