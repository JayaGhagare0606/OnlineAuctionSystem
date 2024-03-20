package com.online.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online.model.AuctionItem;

public interface AuctionItemRepository extends JpaRepository<AuctionItem, Integer>{

}
