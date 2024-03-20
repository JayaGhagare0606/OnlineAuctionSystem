package com.online.serviceimpl;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.online.model.Buyer;
import com.online.service.BuyerService;

@Service
public class BuyerServiceImpl extends HomeService implements BuyerService{

	@Override
	public List<Buyer> buyerList() {
		// TODO Auto-generated method stub
		return buyerRepo.findAll(Sort.by(Sort.Direction.ASC, "fullname"));
	}

	@Override
	public String saveBuyer(Buyer buyer) {
		// TODO Auto-generated method stub
		Buyer save = buyerRepo.save(buyer);
		if(save == null) {
			return "no";
		}
		return "yes";
	}

	@Override
	public Buyer findBuyerById(int id) {
		// TODO Auto-generated method stub
		List<Buyer> buyerList = buyerList();
			Buyer b = null;
			for(Buyer x : buyerList) {
				if(x.getId() == id) {
					b = x;
			}
		}
		return b;
	}

	@Override
	public String updateBuyer(Buyer buyer, int id) {
		// TODO Auto-generated method stub
		Buyer oldbuyer = findBuyerById(id);
		
		oldbuyer.setFullname(buyer.getFullname());
		oldbuyer.setEmail(buyer.getEmail());
		oldbuyer.setMobile(buyer.getMobile());
		oldbuyer.setPassword(buyer.getPassword());
		oldbuyer.setDob(buyer.getDob());
		oldbuyer.setAge(buyer.getAge());
		oldbuyer.setGender(buyer.getGender());
		oldbuyer.setAddress(buyer.getAddress());
		oldbuyer.setPincode(buyer.getPincode());
		oldbuyer.setCity(buyer.getCity());
		oldbuyer.setState(buyer.getState());
		oldbuyer.setCountry(buyer.getCountry());
		oldbuyer.setType(buyer.getType());
		oldbuyer.setStatus(buyer.getStatus());
		oldbuyer.setCreated(new Date());
		oldbuyer.setModified(new Date());
		
		Buyer save = buyerRepo.save(oldbuyer);
		if(save == null) {
			return "no";
		}
		return "yes";
	}

	@Override
	public String deleteBuyer(int id) {
		// TODO Auto-generated method stub
		Buyer buyer = findBuyerById(id);
		buyerRepo.delete(buyer);
		return "done";
	}

	@Override
	public Buyer findByEmail(String email) {
		// TODO Auto-generated method stub
		return buyerRepo.findByEmail(email);
	}

	@Override
	public Buyer findByEmailAndPassword(String email, String password) {
		// TODO Auto-generated method stub
		return buyerRepo.findByEmailAndPassword(email, password);
	}

}
