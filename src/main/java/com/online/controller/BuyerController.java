package com.online.controller;

import java.util.Base64;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.online.context.AdminContext;
import com.online.context.BuyerContext;
import com.online.context.SellerContext;
import com.online.model.AuctionItem;
import com.online.model.Buyer;
import com.online.serviceimpl.AuctionItemServiceImpl;
import com.online.serviceimpl.BuyerServiceImpl;

@Controller
@RequestMapping("/api/buyer")
public class BuyerController {

	@Autowired
	BuyerServiceImpl buyerService;

	@GetMapping("/buyerLogin")
	public String buyerLogin(Model m) {
		m.addAttribute("buyer", new Buyer());
		m.addAttribute("btn", "Login");
		return "buyerLogin";
	}

	@PostMapping("/doBuyerLogin")
	public String doBuyerLogin(@ModelAttribute("buyer") Buyer buyer, Model m) {
		String email = buyer.getEmail();
		String password = buyer.getPassword();

		if (email.isEmpty()) {
			m.addAttribute("error", "Email is Required.");
			m.addAttribute("btn", "Login");
			return "buyerLogin";
		}
		if (password.isEmpty()) {
			m.addAttribute("error", "Password is Required.");
			m.addAttribute("btn", "Login");
			return "buyerLogin";
		}
		Buyer fEAP = buyerService.findByEmailAndPassword(email, password);
		if (fEAP == null) {
			m.addAttribute("error", "Invalid Email or Password.");
			m.addAttribute("btn", "Login");
			return "buyerLogin";
		}
		m.addAttribute("success", "Login Success.");
		BuyerContext.BUYER_USER_NAME=email;
		m.addAttribute("btn", "Logout");
		List<AuctionItem> auctionitemList = auctionItemService.auctionitemList();
		for(AuctionItem item : auctionitemList) {
			if(item.getImage() !=null) {
				String encodeToString = Base64.getEncoder().encodeToString(item.getImage());
				item.setEncodeImage(encodeToString);
			}
		}
		m.addAttribute("auctionitemList", auctionitemList);
		return "buyerHome";
	}

	@GetMapping("/buyerList")
	public String buyerList(Model m) {
		m.addAttribute("fullname", AdminContext.ADMIN_USER_NAME);
		m.addAttribute("type", AdminContext.ADMIN_USER_TYPE);
		m.addAttribute("buyerList", buyerService.buyerList());
		
		return "buyerList";
	}

	@GetMapping("/addBuyer")
	public String addBuyer(Model m) {
		m.addAttribute("buyer", new Buyer());
		m.addAttribute("route", "/api/buyer/doAddBuyer");
		m.addAttribute("btn", "Add Buyer");
		m.addAttribute("fullname", AdminContext.ADMIN_USER_NAME);
		m.addAttribute("type", AdminContext.ADMIN_USER_TYPE);
		m.addAttribute("TitleName", "Add Buyer");
		return "addBuyer";
	}

	@PostMapping("/doAddBuyer")
	public String doAddBuyer(@ModelAttribute("buyer") Buyer buyer, Model m) {
		String fullname = buyer.getFullname();
		String email = buyer.getEmail();
		String mobile = buyer.getMobile();
		String password = buyer.getPassword();
		String dob = buyer.getDob();
		int age = buyer.getAge();
		String gender = buyer.getGender();
		String address = buyer.getAddress();
		int pincode = buyer.getPincode();
		String city = buyer.getCity();
		String state = buyer.getState();
		String country = buyer.getCountry();
		String type = buyer.getType();

		if (fullname.isEmpty()) {
			m.addAttribute("buyer", new Buyer());
			m.addAttribute("route", "/api/buyer/doAddBuyer");
			m.addAttribute("TitleName", "Add Buyer");
			m.addAttribute("btn", "Add Buyer");
			m.addAttribute("error", "Fullname is Required.");
			return "addBuyer";
		}
		if (email.isEmpty()) {
			m.addAttribute("buyer", new Buyer());
			m.addAttribute("route", "/api/buyer/doAddBuyer");
			m.addAttribute("TitleName", "Add Buyer");
			m.addAttribute("btn", "Add Buyer");
			m.addAttribute("error", "Email is Required.");
			return "addBuyer";
		}
		if (mobile.isEmpty()) {
			m.addAttribute("buyer", new Buyer());
			m.addAttribute("route", "/api/buyer/doAddBuyer");
			m.addAttribute("TitleName", "Add Buyer");
			m.addAttribute("btn", "Add Buyer");
			m.addAttribute("error", "Mobile is Required.");
			return "addBuyer";
		}
		if (password.isEmpty()) {
			m.addAttribute("buyer", new Buyer());
			m.addAttribute("route", "/api/buyer/doAddBuyer");
			m.addAttribute("TitleName", "Add Buyer");
			m.addAttribute("btn", "Add Buyer");
			m.addAttribute("error", "Password is Required.");
			return "addBuyer";
		}
		if (dob.isEmpty()) {
			m.addAttribute("buyer", new Buyer());
			m.addAttribute("route", "/api/buyer/doAddBuyer");
			m.addAttribute("TitleName", "Add Buyer");
			m.addAttribute("btn", "Add Buyer");
			m.addAttribute("error", "Dob is Required.");
			return "addBuyer";
		}
		if (age == 0) {
			m.addAttribute("buyer", new Buyer());
			m.addAttribute("route", "/api/buyer/doAddBuyer");
			m.addAttribute("TitleName", "Add Buyer");
			m.addAttribute("btn", "Add Buyer");
			m.addAttribute("error", "Age is Required.");
			return "addBuyer";
		}
		if (gender.isEmpty()) {
			m.addAttribute("buyer", new Buyer());
			m.addAttribute("route", "/api/buyer/doAddBuyer");
			m.addAttribute("TitleName", "Add Buyer");
			m.addAttribute("btn", "Add Buyer");
			m.addAttribute("error", "Gender is Required.");
			return "addBuyer";
		}
		if (address.isEmpty()) {
			m.addAttribute("buyer", new Buyer());
			m.addAttribute("route", "/api/buyer/doAddBuyer");
			m.addAttribute("TitleName", "Add Buyer");
			m.addAttribute("btn", "Add Buyer");
			m.addAttribute("error", "Address is Required.");
			return "addBuyer";
		}
		if (pincode == 0) {
			m.addAttribute("buyer", new Buyer());
			m.addAttribute("route", "/api/buyer/doAddBuyer");
			m.addAttribute("TitleName", "Add Buyer");
			m.addAttribute("btn", "Add Buyer");
			m.addAttribute("error", "Pincode is Required.");
			return "addBuyer";
		}
		if (city.isEmpty()) {
			m.addAttribute("buyer", new Buyer());
			m.addAttribute("route", "/api/buyer/doAddBuyer");
			m.addAttribute("TitleName", "Add Buyer");
			m.addAttribute("btn", "Add Buyer");
			m.addAttribute("error", "City is Required.");
			return "addBuyer";
		}
		if (state.isEmpty()) {
			m.addAttribute("buyer", new Buyer());
			m.addAttribute("route", "/api/buyer/doAddBuyer");
			m.addAttribute("TitleName", "Add Buyer");
			m.addAttribute("btn", "Add Buyer");
			m.addAttribute("error", "State is Required.");
			return "addBuyer";
		}
		if (country.isEmpty()) {
			m.addAttribute("buyer", new Buyer());
			m.addAttribute("route", "/api/buyer/doAddBuyer");
			m.addAttribute("TitleName", "Add Buyer");
			m.addAttribute("btn", "Add Buyer");
			m.addAttribute("error", "Country is Required.");
			return "addBuyer";
		}
		if (type.isEmpty()) {
			m.addAttribute("buyer", new Buyer());
			m.addAttribute("route", "/api/buyer/doAddBuyer");
			m.addAttribute("TitleName", "Add Buyer");
			m.addAttribute("btn", "Add Buyer");
			m.addAttribute("error", "Type is Required.");
			return "addBuyer";
		}
		Buyer fEAP = buyerService.findByEmailAndPassword(email, password);
		if (fEAP != null) {
			m.addAttribute("buyer", new Buyer());
			m.addAttribute("route", "/api/buyer/doAddBuyer");
			m.addAttribute("TitleName", "Add Buyer");
			m.addAttribute("btn", "Add Buyer");
			m.addAttribute("error", "Email already exist.");
			return "addBuyer";
		} else {
			buyer.setCreated(new Date());
			buyer.setModified(new Date());
			buyer.setStatus(1);

			String saveBuyer = buyerService.saveBuyer(buyer);
			if (saveBuyer == "no") {
				m.addAttribute("buyer", new Buyer());
				m.addAttribute("route", "/api/buyer/doAddBuyer");
				m.addAttribute("TitleName", "Add Buyer");
				m.addAttribute("btn", "Add Buyer");
				m.addAttribute("error", "Something Went Wrong.");
				return "addBuyer";
			} else {
				m.addAttribute("buyer", new Buyer());
				m.addAttribute("route", "/api/buyer/doAddBuyer");
				m.addAttribute("TitleName", "Add Buyer");
				m.addAttribute("btn", "Add Buyer");
				m.addAttribute("success", "Buyer Added Successfully.");
				return "addBuyer";
			}

		}

	}

	@GetMapping("/deleteBuyer/{id}")
	public String deleteBuyer(@PathVariable("id") int id, Model m) {
		buyerService.deleteBuyer(id);
		m.addAttribute("buyerList", buyerService.buyerList());
		return "buyerList";
	}

	@GetMapping("/updateBuyer/{id}")
	public String updateBuyer(@PathVariable("id") String id, Model m) {
		Buyer findBuyerById = buyerService.findBuyerById(Integer.parseInt(id));
		m.addAttribute("buyer", new Buyer());
		m.addAttribute("route", "/api/buyer/doUpdateBuyer/" + id);
		m.addAttribute("TitleName", "Update Buyer");
		m.addAttribute("btn", "Update Buyer");
		m.addAttribute("oneBuyer", findBuyerById);
		m.addAttribute("fullname", AdminContext.ADMIN_USER_NAME);
		m.addAttribute("type", AdminContext.ADMIN_USER_TYPE);
		return "addBuyer";
	}

	@PostMapping("/doUpdateBuyer/{id}")
	public String doUpdateBuyer(@PathVariable("id") int id, @ModelAttribute("buyer") Buyer buyer, Model m) {
		String fullname = buyer.getFullname();
		String email = buyer.getEmail();
		String mobile = buyer.getMobile();
		String password = buyer.getPassword();
		String dob = buyer.getDob();
		int age = buyer.getAge();
		String gender = buyer.getGender();
		String address = buyer.getAddress();
		int pincode = buyer.getPincode();
		String city = buyer.getCity();
		String state = buyer.getState();
		String country = buyer.getCountry();
		String type = buyer.getType();
		

		if (fullname.isEmpty()) {
			m.addAttribute("route", "/api/buyer/doUpdateBuyer/" + id);
			m.addAttribute("TitleName", "Update Buyer");
			m.addAttribute("btn", "Update Buyer");
			m.addAttribute("error", "FullName is Required.");
			return "addBuyer";
		}
		if (email.isEmpty()) {
			m.addAttribute("route", "/api/buyer/doUpdateBuyer/" + id);
			m.addAttribute("TitleName", "Update Buyer");
			m.addAttribute("btn", "Update Buyer");
			m.addAttribute("error", "Email is Required.");
			return "addBuyer";
		}
		if (mobile.isEmpty()) {
			m.addAttribute("route", "/api/buyer/doUpdateBuyer/" + id);
			m.addAttribute("TitleName", "Update Buyer");
			m.addAttribute("btn", "Update Buyer");
			m.addAttribute("error", "Mobile is Required.");
			return "addBuyer";
		}
		if (password.isEmpty()) {
			m.addAttribute("route", "/api/buyer/doUpdateBuyer/" + id);
			m.addAttribute("TitleName", "Update Buyer");
			m.addAttribute("btn", "Update Buyer");
			m.addAttribute("error", "Email is Required.");
			return "addBuyer";
		}
		if (dob.isEmpty()) {
			m.addAttribute("route", "/api/buyer/doUpdateBuyer/" + id);
			m.addAttribute("TitleName", "Update Buyer");
			m.addAttribute("btn", "Update Buyer");
			m.addAttribute("error", "Dob is Required.");
			return "addBuyer";
		}
		if (age == 0) {
			m.addAttribute("route", "/api/buyer/doUpdateBuyer/" + id);
			m.addAttribute("TitleName", "Update Buyer");
			m.addAttribute("btn", "Update Buyer");
			m.addAttribute("error", "Age is Required.");
			return "addBuyer";
		}
		if (gender.isEmpty()) {
			m.addAttribute("route", "/api/buyer/doUpdateBuyer/" + id);
			m.addAttribute("TitleName", "Update Buyer");
			m.addAttribute("btn", "Update Buyer");
			m.addAttribute("error", "Gender is Required.");
			return "addBuyer";
		}
		if (address.isEmpty()) {
			m.addAttribute("route", "/api/buyer/doUpdateBuyer/" + id);
			m.addAttribute("TitleName", "Update Buyer");
			m.addAttribute("btn", "Update Buyer");
			m.addAttribute("error", "Address is Required.");
			return "addBuyer";
		}
		if (pincode == 0) {
			m.addAttribute("route", "/api/buyer/doUpdateBuyer/" + id);
			m.addAttribute("TitleName", "Update Buyer");
			m.addAttribute("btn", "Update Buyer");
			m.addAttribute("error", "Pincode is Required.");
			return "addBuyer";
		}
		if (city.isEmpty()) {
			m.addAttribute("route", "/api/buyer/doUpdateBuyer/" + id);
			m.addAttribute("TitleName", "Update Buyer");
			m.addAttribute("btn", "Update Buyer");
			m.addAttribute("error", "City is Required.");
			return "addBuyer";
		}
		if (state.isEmpty()) {
			m.addAttribute("route", "/api/buyer/doUpdateBuyer/" + id);
			m.addAttribute("TitleName", "Update Buyer");
			m.addAttribute("btn", "Update Buyer");
			m.addAttribute("error", "State is Required.");
			return "addBuyer";
		}
		if (country.isEmpty()) {
			m.addAttribute("route", "/api/buyer/doUpdateBuyer/" + id);
			m.addAttribute("TitleName", "Update Buyer");
			m.addAttribute("btn", "Update Buyer");
			m.addAttribute("error", "Country is Required.");
			return "addBuyer";
		}
		if (type.isEmpty()) {
			m.addAttribute("route", "/api/buyer/doUpdateBuyer/" + id);
			m.addAttribute("TitleName", "Update Buyer");
			m.addAttribute("btn", "Update Buyer");
			m.addAttribute("error", "Type is Required.");
			return "addBuyer";
		} else {
			String updateBuyer = buyerService.updateBuyer(buyer, id);
			if (updateBuyer == "no") {
				m.addAttribute("route", "/api/buyer/doUpdateBuyer/" + id);
				m.addAttribute("TitleName", "Update Buyer");
				m.addAttribute("btn", "Update Buyer");
				m.addAttribute("error", "Something Went Wrong.");
				return "addBuyer";
			} else {
				m.addAttribute("route", "/api/buyer/doUpdateBuyer/" + id);
				m.addAttribute("TitleName", "Update Buyer");
				m.addAttribute("btn", "Update Buyer");
				m.addAttribute("success", "Buyer Update Successfully.");
				return "redirect:/api/buyer/buyerList";
			}
		}
	}

	@Autowired
	AuctionItemServiceImpl auctionItemService;

	@GetMapping("/buyerHome")
	public String buyerHome(Model m) {
		m.addAttribute("btn", "Logout");
		List<AuctionItem> auctionitemList = auctionItemService.auctionitemList();
		for(AuctionItem item : auctionitemList) {
			if(item.getImage() !=null) {
				String encodeToString = Base64.getEncoder().encodeToString(item.getImage());
				item.setEncodeImage(encodeToString);
			}
		}
		m.addAttribute("auctionitemList", auctionitemList);
		return "buyerHome";
	}

	@GetMapping("/addBuyerItem")
	public String addBuyerItem(Model m) {
		m.addAttribute("btn", "Logout");
		m.addAttribute("auctionItem", new AuctionItem());
		return "addBuyerItem";
	}

	@PostMapping("/addBuyerItem")
	public String doAddBuyerItem(@RequestParam("file") MultipartFile file,
			@ModelAttribute("auctionItem") AuctionItem auctionItem, Model m) {
		String productname = auctionItem.getProductname();
		String email = auctionItem.getEmail();
		byte[] image = auctionItem.getImage();
		int bidingStartingAmount = auctionItem.getBidingStartingAmount();

		if (productname.isEmpty()) {
			m.addAttribute("btn", "Logout");
			m.addAttribute("auctionItem", new AuctionItem());
			m.addAttribute("error", "ProductName is Required.");
			return "addBuyerItem";
		}
		if (email.isEmpty()) {
			m.addAttribute("btn", "Logout");
			m.addAttribute("auctionItem", new AuctionItem());
			m.addAttribute("error", "Email is Required.");
			return "addBuyerItem";
		}
		if (bidingStartingAmount == 0) {
			m.addAttribute("btn", "Logout");
			m.addAttribute("auctionItem", new AuctionItem());
			m.addAttribute("error", "BidingStartingAmount is Required.");
			return "addBuyerItem";
		}
//	
		else {
			auctionItem.setModified(new Date());
			auctionItem.setCreated(new Date());
			auctionItem.setStatus(1);

			String saveAuctionItem = auctionItemService.saveAuctionItem(auctionItem);
			if (saveAuctionItem == "no") {
				m.addAttribute("btn", "Logout");
				m.addAttribute("auctionItem", new AuctionItem());
				m.addAttribute("error", "Something Went wrong.");
				return "addBuyerItem";
			} else {
				m.addAttribute("btn", "Logout");
				m.addAttribute("auctionItem", new AuctionItem());
				m.addAttribute("success", "Buyer Added Successfully.");
				return "addBuyerItem";
			}
		}
	}

	@GetMapping("/buyerItemHistory")
	public String buyerItemHistory(Model m) {
		List<AuctionItem> auctionitemList = auctionItemService.buyerPurchasedItem(SellerContext.SELLER_USER_NAME);
		for (AuctionItem item : auctionitemList) {
			if (item.getImage() != null) {
				String encodeToString = Base64.getEncoder().encodeToString(item.getImage());
				item.setEncodeImage(encodeToString);
			}
		}
		System.out.println(auctionitemList);
		m.addAttribute("auctionitemList", auctionitemList);
		m.addAttribute("btn", "Logout");
		return "buyerItemHistory";
	}

}
