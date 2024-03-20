package com.online.service;

import java.util.List;

import com.online.model.AuctionItem;

public interface AuctionitemService {
	
	public List<AuctionItem> auctionitemList();
	
	public String saveAuctionItem(AuctionItem auctionitem);
	
	public AuctionItem findAuctionItemByIt(int id);
	
	public String updateAuctionItem(AuctionItem auctionitem, int id);
	
	public String deleteAuctionItem(int id);

}
