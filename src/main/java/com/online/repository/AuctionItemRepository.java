package com.online.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.online.model.AuctionItem;

public interface AuctionItemRepository extends JpaRepository<AuctionItem, Integer>{
	
	@Query(value="Select * from auction_item where email=?1 and status=1", nativeQuery = true)
	public List<AuctionItem> findByEmail(String email);
	
	@Query(value="SELECT * from auction_item where email=?1 and status=?2", nativeQuery = true)
	public List<AuctionItem> soldItemHistory(String email, int status);
	
	@Query(value="select * from auction_item where buyer_user_name= ?1 and status=2", nativeQuery = true)
	public List<AuctionItem> buyerPurchasedItem(String email);
	
	@Query(value="select * from auction_item where status=1" , nativeQuery = true)
	public List<AuctionItem> findByStatus();
	
//	public AuctionItem findEmail(String email);
	
}
