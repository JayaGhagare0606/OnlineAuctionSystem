package com.online.serviceimpl;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.online.context.BuyerContext;
import com.online.model.AuctionItem;
import com.online.service.AuctionitemService;

@Service
public class AuctionItemServiceImpl extends HomeService implements AuctionitemService{

	@Override
	public List<AuctionItem> auctionitemList() {
		// TODO Auto-generated method stub
		return auctionitemRepo.findByStatus();
	}

	@Override
	public String saveAuctionItem(AuctionItem auctionitem) {
		// TODO Auto-generated method stub
		AuctionItem save = auctionitemRepo.save(auctionitem);
		if(save == null) {
			return "no";
		}
		return "yes";
	}

	@Override
	public AuctionItem findAuctionItemById(int id) {
		// TODO Auto-generated method stub
		List<AuctionItem> auctionitemList = auctionitemList();
		AuctionItem a = null;
		for(AuctionItem x : auctionitemList) {
			if(x.getId() == id) {
				a = x;
			}
		}
		return a;
	}

	@Override
	public String updateAuctionItem(AuctionItem auctionitem, int id) {
		// TODO Auto-generated method stub
		AuctionItem oldAuctionItem = findAuctionItemById(id);
		
		
		oldAuctionItem.setBuyerUserName(BuyerContext.BUYER_USER_NAME);
		oldAuctionItem.setBuyerBid(auctionitem.getBuyerBid());
		oldAuctionItem.setStatus(1);
		oldAuctionItem.setModified(new Date());
		
		AuctionItem save = auctionitemRepo.save(oldAuctionItem);
		if(save == null) {
			return "no";
		}
		return "yes";
	}

	@Override
	public String deleteAuctionItem(int id) {
		// TODO Auto-generated method stub
		AuctionItem AuctionItem = findAuctionItemById(id);
		auctionitemRepo.delete(AuctionItem);
		return "done";
	}

	@Override
	public List<AuctionItem> findByEmail(String email) {
		// TODO Auto-generated method stub
		return auctionitemRepo.findByEmail(email);
	}

	@Override
	public AuctionItem acceptUpdateAuctionItem(int id) {
		// TODO Auto-generated method stub
		AuctionItem oldAuctionItem = findAuctionItemById(id);
		// status = 1; (Means processing)
		// status = 2 ; (Means accepted.)
		
		oldAuctionItem.setStatus(2);
		oldAuctionItem.setModified(new Date());
		AuctionItem save = auctionitemRepo.save(oldAuctionItem);
		
		return save ;
	}

	@Override
	public String declineUpdateAuctionItem(int id) {
		// TODO Auto-generated method stub
		AuctionItem oldAuctionItem = findAuctionItemById(id);
		oldAuctionItem.setBuyerUserName("");
		oldAuctionItem.setBuyerBid(0);
		oldAuctionItem.setModified(new Date());
		
		AuctionItem save = auctionitemRepo.save(oldAuctionItem);
		if(save == null) {
			return "no";
		}
		return "yes";
	}

	@Override
	public List<AuctionItem> soldItemHistory(String email, int status) {
		// TODO Auto-generated method stub
		return auctionitemRepo.soldItemHistory(email, status);
	}

	@Override
	public List<AuctionItem> buyerPurchasedItem(String email) {
		// TODO Auto-generated method stub
		return auctionitemRepo.buyerPurchasedItem(email);
	}

//	@Override
//	public AuctionItem findEmail(String email) {
//		// TODO Auto-generated method stub
//		return auctionitemRepo.findEmail(email);
//	}

}
