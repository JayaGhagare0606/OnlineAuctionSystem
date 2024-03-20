package com.online.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{
	
	public Admin findByEmail(String email);
	
	public Admin findByEmailAndPassword(String email, String password);

}
