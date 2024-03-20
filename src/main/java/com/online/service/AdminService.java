package com.online.service;

import java.util.List;

import com.online.model.Admin;

public interface AdminService {
	
	public List<Admin> adminList();
	
	public String saveAdmin(Admin admin);
	
	public Admin findAdminById(int id);
	
	public String updateAdmin(int id, Admin admin);
	
	public String deleteAdmin(int id);
	
	public Admin findByEmail(String email);
	
	public Admin findByEmailAndPassword(String email, String password);
	

}
