package com.online.serviceimpl;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.online.model.Seller;
import com.online.service.SellerService;

@Service
public class SellerServiceImpl extends HomeService implements SellerService{

	@Override
	public List<Seller> sellerList() {
		// TODO Auto-generated method stub
		return sellerRepo.findAll(Sort.by(Sort.Direction.ASC, "fullname"));
	}

	@Override
	public String saveSeller(Seller seller) {
		// TODO Auto-generated method stub
		Seller save = sellerRepo.save(seller);
		if(save == null) {
			return "no";
		}
		return "yes";
	}

	@Override
	public Seller findSellerById(int id) {
		// TODO Auto-generated method stub
		List<Seller> sellerList = sellerList();
		Seller s = null;
		for(Seller t : sellerList) {
			if(t.getId() == id) {
				s = t;
			}
		}
		return s;
	}

	@Override
	public String updateSeller(Seller seller, int id) {
		// TODO Auto-generated method stub
		Seller oldSeller = findSellerById(id);
		
		oldSeller.setFullname(seller.getFullname());
		oldSeller.setEmail(seller.getEmail());
		oldSeller.setMobile(seller.getMobile());
		oldSeller.setPassword(seller.getPassword());
		oldSeller.setDob(seller.getDob());
		oldSeller.setAge(seller.getAge());
		oldSeller.setGender(seller.getGender());
		oldSeller.setAddress(seller.getAddress());
		oldSeller.setPincode(seller.getPincode());
		oldSeller.setCity(seller.getCity());
		oldSeller.setState(seller.getState());
		oldSeller.setCountry(seller.getCountry());
		oldSeller.setType(seller.getType());
		oldSeller.setStatus(seller.getStatus());
		oldSeller.setCreated(new Date());
		oldSeller.setModified(new Date());
		
		Seller save = sellerRepo.save(oldSeller);
		if(save == null) {
			return "no";
		}
		return "yes";
	}

	@Override
	public String deleteSeller(int id) {
		// TODO Auto-generated method stub
		Seller seller = findSellerById(id);
		sellerRepo.delete(seller);
		return "done";
	}

	@Override
	public Seller findByEmail(String email) {
		// TODO Auto-generated method stub
		return sellerRepo.findByEmail(email);
	}

	@Override
	public Seller findByEmailAndPassword(String email, String password) {
		// TODO Auto-generated method stub
		return sellerRepo.findByEmailAndPassword(email, password);
	}

}
