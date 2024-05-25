package com.online.serviceimpl;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.online.model.Admin;
import com.online.service.AdminService;

@Service
public class AdminServiceImpl extends HomeService implements AdminService{

	@Override
	public List<Admin> adminList() {
		// TODO Auto-generated method stub
		return adminRepo.findAll(Sort.by(Sort.Direction.ASC, "fullname"));
	}

	@Override
	public String saveAdmin(Admin admin) {
		// TODO Auto-generated method stub
		Admin save = adminRepo.save(admin);
		if(save == null) {
			return "no";
		}
		return "yes";
	}

	@Override
	public Admin findAdminById(int id) {
		// TODO Auto-generated method stub
		List<Admin> adminList = adminList();
		Admin a = null;
		for(Admin t : adminList) {
			if(t.getId() == id) {
				a = t;
			}
		}
		return a;
	}

	@Override
	public String updateAdmin(int id, Admin admin) {
		// TODO Auto-generated method stub
		Admin oldAdmin = findAdminById(id);
		
		oldAdmin.setFullname(admin.getFullname());
		oldAdmin.setEmail(admin.getEmail());
		oldAdmin.setPassword(admin.getPassword());
		oldAdmin.setMobile(admin.getMobile());
		oldAdmin.setType(admin.getType());
		oldAdmin.setStatus(admin.getStatus());
		oldAdmin.setModified(new Date());
		
		Admin save = adminRepo.save(oldAdmin);
		System.out.println("updateService"+ save);
		if(save == null) {
			return "no";
		}
		return "yes";
	}

	@Override
	public String deleteAdmin(int id) {
		// TODO Auto-generated method stub
		Admin admin = findAdminById(id);
		adminRepo.delete(admin);
		return "done";
	}

	@Override
	public Admin findByEmail(String email) {
		// TODO Auto-generated method stub
		return adminRepo.findByEmail(email);
	}

	@Override
	public Admin findByEmailAndPassword(String email, String password) {
		// TODO Auto-generated method stub
		return adminRepo.findByEmailAndPassword(email, password);
	}

}
