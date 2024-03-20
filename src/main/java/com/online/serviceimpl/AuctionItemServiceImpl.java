package com.online.serviceimpl;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.online.model.AuctionItem;
import com.online.service.AuctionitemService;

@Service
public class AuctionItemServiceImpl extends HomeService implements AuctionitemService{

	@Override
	public List<AuctionItem> auctionitemList() {
		// TODO Auto-generated method stub
		return auctionitemRepo.findAll(Sort.by(Sort.Direction.ASC, "fullname"));
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
	public AuctionItem findAuctionItemByIt(int id) {
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
		AuctionItem oldAuctionItem = findAuctionItemByIt(id);
		
		oldAuctionItem.setFullname(auctionitem.getFullname());
		oldAuctionItem.setEmail(auctionitem.getEmail());
		oldAuctionItem.setImage(auctionitem.getImage());
		oldAuctionItem.setStatus(auctionitem.getStatus());
		oldAuctionItem.setCreated(new Date());
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
		AuctionItem AuctionItem = findAuctionItemByIt(id);
		auctionitemRepo.delete(AuctionItem);
		return "done";
	}

}
