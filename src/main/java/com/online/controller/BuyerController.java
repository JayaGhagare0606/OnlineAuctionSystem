package com.online.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.online.model.Buyer;
import com.online.serviceimpl.BuyerServiceImpl;

@Controller
@RequestMapping("/api/buyer")
public class BuyerController {
	
	@Autowired
	BuyerServiceImpl buyerService;
	
	@GetMapping("/buyerLogin")
	public String buyerLogin(Model m) {
		m.addAttribute("buyer", new Buyer());
		return "buyerLogin";
	}
	
	@PostMapping("/doBuyerLogin")
	public String doBuyerLogin(@ModelAttribute("buyer")Buyer buyer, Model m) {
		String email = buyer.getEmail();
		String password = buyer.getPassword();
		
		if(email.isEmpty()) {
			m.addAttribute("error", "Email is Required.");
			return "buyerLogin";
		}
		if(password.isEmpty()) {
			m.addAttribute("error", "Password is Required.");
			return "buyerLogin";
		}
		Buyer fEAP = buyerService.findByEmailAndPassword(email, password);
		if(fEAP == null) {
			m.addAttribute("error", "Invalid Email or Password.");
			return "buyerLogin";
		}
		m.addAttribute("success", "Login Success.");
		return "buyerLogin";
	}
	
	@GetMapping("/buyerList")
	public String buyerList(Model m) {
		m.addAttribute("buyerList", buyerService.buyerList());
		return "buyerList";
	}
	
	@GetMapping("/addBuyer")
	public String addBuyer(Model m) {
		m.addAttribute("buyer", new Buyer());
		m.addAttribute("route", "/api/buyer/doAddBuyer");
		m.addAttribute("btn", "Add Buyer");
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
	public String deleteBuyer(@PathVariable("id")int id,Model m) {
		buyerService.deleteBuyer(id);
		m.addAttribute("buyerList", buyerService.buyerList());
		return "buyerList";
	}
	@GetMapping("/updateBuyer/{id}")
	public String updateBuyer(@PathVariable("id") String id, Model m) {
		Buyer findBuyerById = buyerService.findBuyerById(Integer.parseInt(id));
		m.addAttribute("buyer", new Buyer());
		m.addAttribute("route", "/api/buyer/doUpdateBuyer/"+id);
		m.addAttribute("TitleName", "Update Buyer");
		m.addAttribute("btn", "Update Buyer");
		m.addAttribute("oneBuyer", findBuyerById);
		return "addBuyer";
	}
	@PostMapping("/doUpdateBuyer/{id}")
	public String doUpdateBuyer(@PathVariable("id")int id,@ModelAttribute("buyer")Buyer buyer, Model m) {
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
		
		if(fullname.isEmpty()) {
			m.addAttribute("route", "/api/buyer/doUpdateBuyer/"+id);
			m.addAttribute("TitleName", "Update Buyer");
			m.addAttribute("btn", "Update Buyer");
			m.addAttribute("error", "FullName is Required.");
			return "addBuyer";
		}
		if(email.isEmpty()) {
			m.addAttribute("route", "/api/buyer/doUpdateBuyer/"+id);
			m.addAttribute("TitleName", "Update Buyer");
			m.addAttribute("btn", "Update Buyer");
			m.addAttribute("error", "Email is Required.");
			return "addBuyer";
		}
		if(mobile.isEmpty()) {
			m.addAttribute("route", "/api/buyer/doUpdateBuyer/"+id);
			m.addAttribute("TitleName", "Update Buyer");
			m.addAttribute("btn", "Update Buyer");
			m.addAttribute("error", "Mobile is Required.");
			return "addBuyer";
		}
		if(password.isEmpty()) {
			m.addAttribute("route", "/api/buyer/doUpdateBuyer/"+id);
			m.addAttribute("TitleName", "Update Buyer");
			m.addAttribute("btn", "Update Buyer");
			m.addAttribute("error", "Email is Required.");
			return "addBuyer";
		}
		if(dob.isEmpty()) {
			m.addAttribute("route", "/api/buyer/doUpdateBuyer/"+id);
			m.addAttribute("TitleName", "Update Buyer");
			m.addAttribute("btn", "Update Buyer");
			m.addAttribute("error", "Dob is Required.");
			return "addBuyer";
		}
		if(age == 0) {
			m.addAttribute("route", "/api/buyer/doUpdateBuyer/"+id);
			m.addAttribute("TitleName", "Update Buyer");
			m.addAttribute("btn", "Update Buyer");
			m.addAttribute("error", "Age is Required.");
			return "addBuyer";
		}
		if(gender.isEmpty()) {
			m.addAttribute("route", "/api/buyer/doUpdateBuyer/"+id);
			m.addAttribute("TitleName", "Update Buyer");
			m.addAttribute("btn", "Update Buyer");
			m.addAttribute("error", "Gender is Required.");
			return "addBuyer";
		}
		if(address.isEmpty()) {
			m.addAttribute("route", "/api/buyer/doUpdateBuyer/"+id);
			m.addAttribute("TitleName", "Update Buyer");
			m.addAttribute("btn", "Update Buyer");
			m.addAttribute("error", "Address is Required.");
			return "addBuyer";
		}
		if(pincode == 0) {
			m.addAttribute("route", "/api/buyer/doUpdateBuyer/"+id);
			m.addAttribute("TitleName", "Update Buyer");
			m.addAttribute("btn", "Update Buyer");
			m.addAttribute("error", "Pincode is Required.");
			return "addBuyer";
		}
		if(city.isEmpty()) {
			m.addAttribute("route", "/api/buyer/doUpdateBuyer/"+id);
			m.addAttribute("TitleName", "Update Buyer");
			m.addAttribute("btn", "Update Buyer");
			m.addAttribute("error", "City is Required.");
			return "addBuyer";
		}
		if(state.isEmpty()) {
			m.addAttribute("route", "/api/buyer/doUpdateBuyer/"+id);
			m.addAttribute("TitleName", "Update Buyer");
			m.addAttribute("btn", "Update Buyer");
			m.addAttribute("error", "State is Required.");
			return "addBuyer";
		}
		if(country.isEmpty()) {
			m.addAttribute("route", "/api/buyer/doUpdateBuyer/"+id);
			m.addAttribute("TitleName", "Update Buyer");
			m.addAttribute("btn", "Update Buyer");
			m.addAttribute("error", "Country is Required.");
			return "addBuyer";
		}
		if(type.isEmpty()) {
			m.addAttribute("route", "/api/buyer/doUpdateBuyer/"+id);
			m.addAttribute("TitleName", "Update Buyer");
			m.addAttribute("btn", "Update Buyer");
			m.addAttribute("error", "Type is Required.");
			return "addBuyer";
		}
		else {
			String updateBuyer = buyerService.updateBuyer(buyer, id);
			if(updateBuyer == "no") {
				m.addAttribute("route", "/api/buyer/doUpdateBuyer/"+id);
				m.addAttribute("TitleName", "Update Buyer");
				m.addAttribute("btn", "Update Buyer");
				m.addAttribute("error", "Something Went Wrong.");
				return "addBuyer";
			}else {
				m.addAttribute("route", "/api/buyer/doUpdateBuyer/"+id);
				m.addAttribute("TitleName", "Update Buyer");
				m.addAttribute("btn", "Update Buyer");
				m.addAttribute("success", "Buyer Update Successfully.");
				return "redirect:/api/buyer/buyerList";
			}
		}
	}

}
