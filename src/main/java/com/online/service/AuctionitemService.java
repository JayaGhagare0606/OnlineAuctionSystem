package com.online.service;

import java.util.List;

import com.online.model.AuctionItem;

public interface AuctionitemService {

	public List<AuctionItem> auctionitemList();

	public String saveAuctionItem(AuctionItem auctionitem);

	public AuctionItem findAuctionItemById(int id);

	public String updateAuctionItem(AuctionItem auctionitem, int id);

	public String deleteAuctionItem(int id);

	public List<AuctionItem> findByEmail(String email);
	
	public AuctionItem acceptUpdateAuctionItem(int id);
	
	public String declineUpdateAuctionItem(int id);
	
	public List<AuctionItem> soldItemHistory(String email, int status);
	
	public List<AuctionItem> buyerPurchasedItem(String email);
	
//	public AuctionItem findEmail(String email);
}
