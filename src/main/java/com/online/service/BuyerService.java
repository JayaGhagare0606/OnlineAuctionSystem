package com.online.service;

import java.util.List;

import com.online.model.Buyer;

public interface BuyerService {
	
	public List<Buyer> buyerList();
	
	public String saveBuyer(Buyer buyer);
	
	public Buyer findBuyerById(int id);
	
	public String updateBuyer(Buyer buyer, int id);
	
	public String deleteBuyer(int id);
	
	public Buyer findByEmail(String email);
	
	public Buyer findByEmailAndPassword(String email, String password);

}
