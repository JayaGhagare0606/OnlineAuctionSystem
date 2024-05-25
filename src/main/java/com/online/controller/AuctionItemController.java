package com.online.controller;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.online.context.SellerContext;
import com.online.model.AuctionItem;
import com.online.serviceimpl.AuctionItemServiceImpl;

@Controller
@RequestMapping("/api/auctionItem")
public class AuctionItemController {

	@Autowired
	AuctionItemServiceImpl auctionItemService;

	@GetMapping("/delete/{id}")
	public String deleteAuctionItem(@PathVariable("id") int id, Model m) {
		auctionItemService.deleteAuctionItem(id);
		List<AuctionItem> auctionitemList = auctionItemService.findByEmail(SellerContext.SELLER_USER_NAME );
		for (AuctionItem item : auctionitemList) {
			if (item.getImage() != null) {
				String encodeToString = Base64.getEncoder().encodeToString(item.getImage());
				item.setEncodeImage(encodeToString);
			}
		}
		m.addAttribute("auctionitemList", auctionitemList);
		m.addAttribute("btn", "Logout");
		return "sellerHome";
	}

	@PostMapping("/update/{id}")
	public String updateAuctionItem(@ModelAttribute("auctionItem") AuctionItem auctionItem, Model m,
			@PathVariable("id") int id) {

		auctionItemService.updateAuctionItem(auctionItem, id);
		List<AuctionItem> auctionitemList = auctionItemService.auctionitemList();
		for (AuctionItem item : auctionitemList) {
			if (item.getImage() != null) {
				String encodeToString = Base64.getEncoder().encodeToString(item.getImage());
				item.setEncodeImage(encodeToString);
			}
		}
		m.addAttribute("auctionitemList", auctionitemList);
		m.addAttribute("btn", "Logout");
//		System.out.println("AuctionItemList => "+ auctionitemList);
		return "buyerHome";
	}

	@GetMapping("/acceptUpdate/{id}")
	public String acceptUpdate(@PathVariable("id") int id, Model m) {
		AuctionItem acceptUpdateAuctionItem = auctionItemService.acceptUpdateAuctionItem(id);
		List<AuctionItem> auctionitemList = auctionItemService.soldItemHistory(SellerContext.SELLER_USER_NAME,acceptUpdateAuctionItem.getStatus());
		for (AuctionItem item : auctionitemList) {
			if (item.getImage() != null) {
				String encodeToString = Base64.getEncoder().encodeToString(item.getImage());
				item.setEncodeImage(encodeToString);
			}
		}
		m.addAttribute("auctionitemList", auctionitemList);
		m.addAttribute("btn", "Logout");
		return "sellerItemHistory";

	}

	@GetMapping("/declineUpdate/{id}")
	public String declineUpdate(@PathVariable("id") int id, Model m) {
		auctionItemService.declineUpdateAuctionItem(id);
		List<AuctionItem> auctionitemList = auctionItemService.findByEmail(SellerContext.SELLER_USER_NAME);
		for (AuctionItem item : auctionitemList) {
			if (item.getImage() != null) {
				String encodeToString = Base64.getEncoder().encodeToString(item.getImage());
				item.setEncodeImage(encodeToString);
			}
		}
		m.addAttribute("auctionitemList", auctionitemList);
		m.addAttribute("btn", "Logout");
		return "sellerHome";

	}

}
