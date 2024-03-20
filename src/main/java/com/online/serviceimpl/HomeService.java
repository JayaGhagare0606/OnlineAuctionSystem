package com.online.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.online.repository.AdminRepository;
import com.online.repository.AuctionItemRepository;
import com.online.repository.BuyerRepository;
import com.online.repository.SellerRepository;

public class HomeService {
	
	@Autowired
	AdminRepository adminRepo;
	
	@Autowired
	BuyerRepository buyerRepo;
	
	@Autowired
	SellerRepository sellerRepo;
	
	@Autowired
	AuctionItemRepository auctionitemRepo;
	

}
