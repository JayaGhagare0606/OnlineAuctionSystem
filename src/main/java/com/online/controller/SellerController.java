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

import com.online.model.Seller;
import com.online.serviceimpl.SellerServiceImpl;

@Controller
@RequestMapping("/api/seller")
public class SellerController {

	@Autowired
	SellerServiceImpl sellerService;

	@GetMapping("/sellerLogin")
	public String sellerLogin(Model m) {
		m.addAttribute("seller", new Seller());
		return "sellerLogin";
	}

	@PostMapping("/doSellerLogin")
	public String doSellerLogin(@ModelAttribute("seller") Seller seller, Model m) {
		String email = seller.getEmail();
		String password = seller.getPassword();

		if (email.isEmpty()) {
			m.addAttribute("error", "Email is Required.");
			return "sellerLogin";
		}
		if (password.isEmpty()) {
			m.addAttribute("error", "Password is Required.");
			return "sellerLogin";
		}
		Seller fEAP = sellerService.findByEmailAndPassword(email, password);
		if (fEAP == null) {
			m.addAttribute("error", "Invalid Email or Password.");
			return "sellerLogin";
		}
		m.addAttribute("success", "Login Success.");
		return "sellerLogin";
	}

	@GetMapping("/sellerList")
	public String sellerList(Model m) {
		m.addAttribute("sellerList", sellerService.sellerList());
		return "sellerList";
	}

	@GetMapping("/addSeller")
	public String addSeller(Model m) {
		m.addAttribute("seller", new Seller());
		m.addAttribute("route", "/api/seller/doAddSeller");
		m.addAttribute("TitleName", "Add Seller");
		m.addAttribute("btn", "Add Seller");
		return "addSeller";
	}

	@PostMapping("/doAddSeller")
	public String doAddSeller(@ModelAttribute("seller") Seller seller, Model m) {
		String fullname = seller.getFullname();
		String email = seller.getEmail();
		String mobile = seller.getMobile();
		String password = seller.getPassword();
		String dob = seller.getDob();
		int age = seller.getAge();
		String gender = seller.getGender();
		String address = seller.getAddress();
		int pincode = seller.getPincode();
		String city = seller.getCity();
		String state = seller.getState();
		String country = seller.getCountry();
		String type = seller.getType();

		if (fullname.isEmpty()) {
			m.addAttribute("seller", new Seller());
			m.addAttribute("route", "/api/seller/doAddSeller");
			m.addAttribute("TitleName", "Add Seller");
			m.addAttribute("btn", "Add Seller");
			m.addAttribute("error", "Fullname is Required.");
			return "addSeller";
		}
		if (email.isEmpty()) {
			m.addAttribute("seller", new Seller());
			m.addAttribute("route", "/api/seller/doAddSeller");
			m.addAttribute("TitleName", "Add Seller");
			m.addAttribute("btn", "Add Seller");
			m.addAttribute("error", "Email is Required.");
			return "addSeller";
		}
		if (mobile.isEmpty()) {
			m.addAttribute("seller", new Seller());
			m.addAttribute("route", "/api/seller/doAddSeller");
			m.addAttribute("TitleName", "Add Seller");
			m.addAttribute("btn", "Add Seller");
			m.addAttribute("error", "Mobile is Required.");
			return "addSeller";
		}
		if (password.isEmpty()) {
			m.addAttribute("seller", new Seller());
			m.addAttribute("route", "/api/seller/doAddSeller");
			m.addAttribute("TitleName", "Add Seller");
			m.addAttribute("btn", "Add Seller");
			m.addAttribute("error", "Password is Required.");
			return "addSeller";
		}
		if (dob.isEmpty()) {
			m.addAttribute("seller", new Seller());
			m.addAttribute("route", "/api/seller/doAddSeller");
			m.addAttribute("TitleName", "Add Seller");
			m.addAttribute("btn", "Add Seller");
			m.addAttribute("error", "Dob is Required.");
			return "addSeller";
		}
		if (age == 0) {
			m.addAttribute("seller", new Seller());
			m.addAttribute("route", "/api/seller/doAddSeller");
			m.addAttribute("TitleName", "Add Seller");
			m.addAttribute("btn", "Add Seller");
			m.addAttribute("error", "Age is Required.");
			return "addSeller";
		}
		if (gender.isEmpty()) {
			m.addAttribute("seller", new Seller());
			m.addAttribute("route", "/api/seller/doAddSeller");
			m.addAttribute("TitleName", "Add Seller");
			m.addAttribute("btn", "Add Seller");
			m.addAttribute("error", "Gender is Required.");
			return "addSeller";
		}
		if (address.isEmpty()) {
			m.addAttribute("seller", new Seller());
			m.addAttribute("route", "/api/seller/doAddSeller");
			m.addAttribute("TitleName", "Add Seller");
			m.addAttribute("btn", "Add Seller");
			m.addAttribute("error", "Address is Required.");
			return "addSeller";
		}
		if (pincode == 0) {
			m.addAttribute("seller", new Seller());
			m.addAttribute("route", "/api/seller/doAddSeller");
			m.addAttribute("TitleName", "Add Seller");
			m.addAttribute("btn", "Add Seller");
			m.addAttribute("error", "Pincode is Required.");
			return "addSeller";
		}
		if (city.isEmpty()) {
			m.addAttribute("seller", new Seller());
			m.addAttribute("route", "/api/seller/doAddSeller");
			m.addAttribute("TitleName", "Add Seller");
			m.addAttribute("btn", "Add Seller");
			m.addAttribute("error", "City is Required.");
			return "addSeller";
		}
		if (state.isEmpty()) {
			m.addAttribute("seller", new Seller());
			m.addAttribute("route", "/api/seller/doAddSeller");
			m.addAttribute("TitleName", "Add Seller");
			m.addAttribute("btn", "Add Seller");
			m.addAttribute("error", "State is Required.");
			return "addSeller";
		}
		if (country.isEmpty()) {
			m.addAttribute("seller", new Seller());
			m.addAttribute("route", "/api/seller/doAddSeller");
			m.addAttribute("TitleName", "Add Seller");
			m.addAttribute("btn", "Add Seller");
			m.addAttribute("error", "Country is Required.");
			return "addSeller";
		}
		if (type.isEmpty()) {
			m.addAttribute("seller", new Seller());
			m.addAttribute("route", "/api/seller/doAddSeller");
			m.addAttribute("TitleName", "Add Seller");
			m.addAttribute("btn", "Add Seller");
			m.addAttribute("error", "Type is Required.");
			return "addSeller";
		}
		Seller fEAP = sellerService.findByEmailAndPassword(email, password);
		if (fEAP != null) {
			m.addAttribute("seller", new Seller());
			m.addAttribute("route", "/api/seller/doAddSeller");
			m.addAttribute("TitleName", "Add Seller");
			m.addAttribute("btn", "Add Seller");
			m.addAttribute("error", "Email already exist.");
			return "addSeller";
		} else {
			seller.setCreated(new Date());
			seller.setModified(new Date());
			seller.setStatus(1);

			String saveSeller = sellerService.saveSeller(seller);
			if (saveSeller == "no") {
				m.addAttribute("seller", new Seller());
				m.addAttribute("route", "/api/seller/doAddSeller");
				m.addAttribute("TitleName", "Add Seller");
				m.addAttribute("btn", "Add Seller");
				m.addAttribute("error", "Something Went Wrong.");
				return "addSeller";
			} else {
				m.addAttribute("seller", new Seller());
				m.addAttribute("route", "/api/seller/doAddSeller");
				m.addAttribute("TitleName", "Add Seller");
				m.addAttribute("btn", "Add Seller");
				m.addAttribute("success", "Seller Added Successfully.");
				return "addSeller";
			}

		}

	}
	
	@GetMapping("/deleteSeller/{id}")
	public String deleteSeller(@PathVariable("id")int id, Model m) {
		sellerService.deleteSeller(id);
		m.addAttribute("sellerList", sellerService.sellerList());
		return "sellerList";
	}
	@GetMapping("/updateSeller/{id}")
	public String updateSeller(@PathVariable("id") String id, Model m) {
		Seller findSellerById = sellerService.findSellerById(Integer.parseInt(id));
		m.addAttribute("seller", new Seller());
		m.addAttribute("route", "/api/seller/doUpdateSeller/"+id);
		m.addAttribute("TitleName", "Update Seller");
		m.addAttribute("btn", "Update Seller");
		m.addAttribute("oneSeller", findSellerById);
		return "addSeller";
	}
	@PostMapping("/doUpdateSeller/{id}")
	public String doUpdateSeller(@PathVariable("id")int id,@ModelAttribute("seller")Seller seller, Model m) {
		String fullname = seller.getFullname();
		String email = seller.getEmail();
		String mobile = seller.getMobile();
		String password = seller.getPassword();
		String dob = seller.getDob();
		int age = seller.getAge();
		String gender = seller.getGender();
		String address = seller.getAddress();
		int pincode = seller.getPincode();
		String city = seller.getCity();
		String state = seller.getState();
		String country = seller.getCountry();
		String type = seller.getType();
		
		if(fullname.isEmpty()) {
			m.addAttribute("route", "/api/seller/doUpdateSeller/"+id);
			m.addAttribute("TitleName", "Update Seller");
			m.addAttribute("btn", "Update Seller");
			m.addAttribute("error", "FullName is Required.");
			return "addSeller";
		}
		if(email.isEmpty()) {
			m.addAttribute("route", "/api/seller/doUpdateSeller/"+id);
			m.addAttribute("TitleName", "Update Seller");
			m.addAttribute("btn", "Update Seller");
			m.addAttribute("error", "Email is Required.");
			return "addSeller";
		}
		if(mobile.isEmpty()) {
			m.addAttribute("route", "/api/seller/doUpdateSeller/"+id);
			m.addAttribute("TitleName", "Update Seller");
			m.addAttribute("btn", "Update Seller");
			m.addAttribute("error", "Mobile is Required.");
			return "addSeller";
		}
		if(password.isEmpty()) {
			m.addAttribute("route", "/api/seller/doUpdateSeller/"+id);
			m.addAttribute("TitleName", "Update Seller");
			m.addAttribute("btn", "Update Seller");
			m.addAttribute("error", "Email is Required.");
			return "addSeller";
		}
		if(dob.isEmpty()) {
			m.addAttribute("route", "/api/seller/doUpdateSeller/"+id);
			m.addAttribute("TitleName", "Update Seller");
			m.addAttribute("btn", "Update Seller");
			m.addAttribute("error", "Dob is Required.");
			return "addSeller";
		}
		if(age == 0) {
			m.addAttribute("route", "/api/seller/doUpdateSeller/"+id);
			m.addAttribute("TitleName", "Update Seller");
			m.addAttribute("btn", "Update Seller");
			m.addAttribute("error", "Age is Required.");
			return "addSeller";
		}
		if(gender.isEmpty()) {
			m.addAttribute("route", "/api/seller/doUpdateSeller/"+id);
			m.addAttribute("TitleName", "Update Seller");
			m.addAttribute("btn", "Update Seller");
			m.addAttribute("error", "Gender is Required.");
			return "addSeller";
		}
		if(address.isEmpty()) {
			m.addAttribute("route", "/api/seller/doUpdateSeller/"+id);
			m.addAttribute("TitleName", "Update Seller");
			m.addAttribute("btn", "Update Seller");
			m.addAttribute("error", "Address is Required.");
			return "addSeller";
		}
		if(pincode == 0) {
			m.addAttribute("route", "/api/seller/doUpdateSeller/"+id);
			m.addAttribute("TitleName", "Update Seller");
			m.addAttribute("btn", "Update Seller");
			m.addAttribute("error", "Pincode is Required.");
			return "addSeller";
		}
		if(city.isEmpty()) {
			m.addAttribute("route", "/api/seller/doUpdateSeller/"+id);
			m.addAttribute("TitleName", "Update Seller");
			m.addAttribute("btn", "Update Seller");
			m.addAttribute("error", "City is Required.");
			return "addSeller";
		}
		if(state.isEmpty()) {
			m.addAttribute("route", "/api/seller/doUpdateSeller/"+id);
			m.addAttribute("TitleName", "Update Seller");
			m.addAttribute("btn", "Update Seller");
			m.addAttribute("error", "State is Required.");
			return "addSeller";
		}
		if(country.isEmpty()) {
			m.addAttribute("route", "/api/seller/doUpdateSeller/"+id);
			m.addAttribute("TitleName", "Update Seller");
			m.addAttribute("btn", "Update Seller");
			m.addAttribute("error", "Country is Required.");
			return "addSeller";
		}
		if(type.isEmpty()) {
			m.addAttribute("route", "/api/seller/doUpdateSeller/"+id);
			m.addAttribute("TitleName", "Update Seller");
			m.addAttribute("btn", "Update Seller");
			m.addAttribute("error", "Type is Required.");
			return "addSeller";
		}
		else {
			String updateSeller = sellerService.updateSeller(seller, id);
			if(updateSeller == "no") {
				m.addAttribute("route", "/api/seller/doUpdateSeller/"+id);
				m.addAttribute("TitleName", "Update Seller");
				m.addAttribute("btn", "Update Seller");
				m.addAttribute("error", "Something Went Wrong.");
				return "addSeller";
			}else {
				m.addAttribute("route", "/api/seller/doUpdateSeller/"+id);
				m.addAttribute("TitleName", "Update Seller");
				m.addAttribute("btn", "Update Seller");
				m.addAttribute("success", "Seller Update Successfully.");
				return "redirect:/api/seller/sellerList";
			}
		}
	}

}
