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

import com.online.model.Admin;
import com.online.serviceimpl.AdminServiceImpl;

@Controller
@RequestMapping("/api/admin")
public class AdminController {
	@Autowired
	AdminServiceImpl adminService;

	@GetMapping("/adminLogin")
	public String adminLogin(Model m) {
		m.addAttribute("admin", new Admin());
		return "adminLogin";
	}

	@PostMapping("/doAdminLogin")
	public String doAdminLogin(@ModelAttribute("admin") Admin admin, Model m) {
		String email = admin.getEmail();
		String password = admin.getPassword();

		if (email.isEmpty()) {
			m.addAttribute("error", "Email is Required.");
			return "adminLogin";
		}

		if (password.isEmpty()) {
			m.addAttribute("error", "Password is Required.");
			return "adminLogin";
		}
		Admin fEAP = adminService.findByEmailAndPassword(email, password);
		if (fEAP == null) {
			m.addAttribute("error", "Invalid Email or password.");
			return "adminLogin";
		}

		m.addAttribute("data", fEAP);
		return "dashboard";
	}

	@GetMapping("/adminList")
	public String adminList(Model m) {
		m.addAttribute("adminList", adminService.adminList());
		return "adminList";
	}

	@GetMapping("/dashboard")
	public String dashboard() {
		return "dashboard";
	}

	@GetMapping("/addAdmin")
	public String addAdmin(Model m) {
		m.addAttribute("admin", new Admin());
		m.addAttribute("route", "/api/admin/doAddAdmin");
		m.addAttribute("TitleName", "AddAdmin");
		m.addAttribute("btn", "Add Admin");
		return "addAdmin";
	}

	@PostMapping("/doAddAdmin")
	public String doAddAdmin(@ModelAttribute("admin") Admin admin, Model m) {
		String fullname = admin.getFullname();
		String email = admin.getEmail();
		String password = admin.getPassword();
		String mobile = admin.getMobile();
		String type = admin.getType();

		if (fullname.isEmpty()) {
			m.addAttribute("route", "/api/admin/doAddAdmin");
			m.addAttribute("TitleName", "AddAdmin");
			m.addAttribute("btn", "Add Admin");
			m.addAttribute("error", "FullName is Required.");
			return "addAdmin";
		}
		if (email.isEmpty()) {
			m.addAttribute("route", "/api/admin/doAddAdmin");
			m.addAttribute("TitleName", "AddAdmin");
			m.addAttribute("btn", "Add Admin");
			m.addAttribute("error", "Email is Required.");
			return "addAdmin";
		}
		if (password.isEmpty()) {
			m.addAttribute("route", "/api/admin/doAddAdmin");
			m.addAttribute("TitleName", "AddAdmin");
			m.addAttribute("btn", "Add Admin");
			m.addAttribute("error", "Password is Required.");
			return "addAdmin";
		}
		if (mobile.isEmpty()) {
			m.addAttribute("route", "/api/admin/doAddAdmin");
			m.addAttribute("TitleName", "AddAdmin");
			m.addAttribute("btn", "Add Admin");
			m.addAttribute("error", "Mobile is Required.");
			return "addAdmin";
		}
		if (type.isEmpty()) {
			m.addAttribute("route", "/api/admin/doAddAdmin");
			m.addAttribute("TitleName", "AddAdmin");
			m.addAttribute("btn", "Add Admin");
			m.addAttribute("error", "Type is Required.");
			return "addAdmin";
		}
		Admin fEAP = adminService.findByEmailAndPassword(email, password);
		if (fEAP != null) {
			m.addAttribute("route", "/api/admin/doAddAdmin");
			m.addAttribute("TitleName", "AddAdmin");
			m.addAttribute("btn", "Add Admin");
			m.addAttribute("error", "Email And Password Already Present.");
			return "addAdmin";
		} else {
			admin.setCreated(new Date());
			admin.setModified(new Date());
			admin.setStatus(1);
			String saveAdmin = adminService.saveAdmin(admin);

			if (saveAdmin == "no") {
				m.addAttribute("route", "/api/admin/doAddAdmin");
				m.addAttribute("TitleName", "AddAdmin");
				m.addAttribute("btn", "Add Admin");
				m.addAttribute("error", "Something Went Wrong.");
				return "addAdmin";
			} else {
				m.addAttribute("route", "/api/admin/doAddAdmin");
				m.addAttribute("TitleName", "AddAdmin");
				m.addAttribute("btn", "Add Admin");
				m.addAttribute("success", "Add Admin Successfully.");
				return "addAdmin";

			}

		}

	}

	@GetMapping("/deleteAdmin/{id}")
	public String deleteAdmin(@PathVariable("id") int id, Model m) {
		adminService.deleteAdmin(id);
		m.addAttribute("adminList", adminService.adminList());
		return "adminList";
	}

	@GetMapping("/updateAdmin/{id}")
	public String updateAdmin(@PathVariable("id") String id, Model m) {
		Admin findAdminById = adminService.findAdminById(Integer.parseInt(id));
		m.addAttribute("route", "/api/admin/UpdateAdmin/"+id);
		m.addAttribute("admin", new Admin());
		m.addAttribute("oneAdmin", findAdminById);
		m.addAttribute("btn", "Update Admin");
		m.addAttribute("TitleName", "Update Admin");
		return "addAdmin";
	}
	
	@PostMapping("/UpdateAdmin/{id}")
	public String UpdateAdmin(@PathVariable("id")int id,@ModelAttribute("admin")Admin admin, Model m) {
		String fullname = admin.getFullname();
		String email = admin.getEmail();
		String password = admin.getPassword();
		String mobile = admin.getMobile();
		String type = admin.getType();
		
		System.out.println(fullname);
		System.out.println(email);
		System.out.println(password);
		System.out.println(mobile);
		System.out.println(type);
		
		if(fullname.isEmpty()) {
			m.addAttribute("route", "/api/admin/UpdateAdmin/"+id);
			m.addAttribute("TitleName", "Update Admin");
			m.addAttribute("btn", "Update Admin");
			m.addAttribute("error", "Fullname is Required.");
			return "addAdmin";
		}
		if(email.isEmpty()) {
			m.addAttribute("route", "/api/admin/UpdateAdmin/"+id);
			m.addAttribute("TitleName", "Update Admin");
			m.addAttribute("btn", "Update Admin");
			m.addAttribute("error", "Email is Required.");
			return "addAdmin";
		}
		if(password.isEmpty()) {
			m.addAttribute("route", "/api/admin/UpdateAdmin/"+id);
			m.addAttribute("TitleName", "Update Admin");
			m.addAttribute("btn", "Update Admin");
			m.addAttribute("error", "Password is Required.");
			return "addAdmin";
		}
		if(mobile.isEmpty()) {
			m.addAttribute("route", "/api/admin/UpdateAdmin/"+id);
			m.addAttribute("TitleName", "Update Admin");
			m.addAttribute("btn", "Update Admin");
			m.addAttribute("error", "Mobile is Required.");
			return "addAdmin";
		}
		if(type.isEmpty()) {
			m.addAttribute("route", "/api/admin/UpdateAdmin/"+id);
			m.addAttribute("TitleName", "Update Admin");
			m.addAttribute("btn", "Update Admin");
			m.addAttribute("error", "Type is Required.");
			return "addAdmin";
		}
		else {
			
			String updateAdmin = adminService.updateAdmin(id, admin);
			if(updateAdmin == "no") {
				m.addAttribute("route", "/api/admin/UpdateAdmin/"+id);
				m.addAttribute("TitleName", "Update Admin");
				m.addAttribute("btn", "Update Admin");
				m.addAttribute("error", "Something Went Wrong.");
				return "addAdmin";
				
			}
			else {
				m.addAttribute("route", "/api/admin/UpdateAdmin/"+id);
				m.addAttribute("TitleName", "Update Admin");
				m.addAttribute("btn", "Update Admin");
				m.addAttribute("success", "Update Admin Successfully.");
				return "redirect:/api/admin/adminList";
				
			}
		}
	}

}
