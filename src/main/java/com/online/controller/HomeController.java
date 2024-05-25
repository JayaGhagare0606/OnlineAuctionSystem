package com.online.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.online.model.Admin;
import com.online.serviceimpl.EmailSenderService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String getHome(Model m) {
		m.addAttribute("btn", "Login");
		return "home";
	}
	@GetMapping("/api/login")
	public String login(Model m) {
		m.addAttribute("btn", "Login");
		return "login";
	}
	
	@GetMapping("/api/service")
	public String service(Model m) {
		m.addAttribute("btn", "Login");
		return "service";
	}
	
	@Autowired
	private EmailSenderService emailSender;
	
	@GetMapping("/api/aboutUs")
	public String aboutUs(Model m) {
		Admin admin = new Admin();
		m.addAttribute("admin", admin);
		m.addAttribute("btn", "Login");
		return "aboutUs";
	}
	
	@PostMapping("/api/aboutUs")
	public String doaboutUs(HttpServletRequest req, Model m) {
		
		String name = req.getParameter("fullname");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String message = req.getParameter("message");
		
		if(name.isEmpty() ) {
			m.addAttribute("btn", "Login");
			m.addAttribute("error", "Fullname is Required.");
		
			return "aboutUs";
		}
		if(email.isEmpty()) {
			m.addAttribute("btn", "Login");
			m.addAttribute("error", "Email is Required.");
			return "aboutUs";
		}
		if(phone.isEmpty()){
			m.addAttribute("btn", "Login");
			m.addAttribute("error", "Phone is Required.");
				return "aboutUs";
		}
		
		
		emailSender.sendMail("jayaghagare2022@gmail.com", 
				"Enquiry about us from: "+email, 
				"Name: "+name+"\nEmail: "+email+"\nPhone: "+phone+"\n"+message
				);
		name = null;
		email = null;
		phone = null;
		message = null;
		m.addAttribute("btn", "Login");
		m.addAttribute("success", "We will reach you soon with all our services.");
		
		return "aboutUs";
	}
}
