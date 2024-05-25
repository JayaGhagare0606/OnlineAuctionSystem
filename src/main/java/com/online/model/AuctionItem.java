package com.online.model;

import java.util.Arrays;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class AuctionItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String productname;
	
	private String email;
	
	@Lob
	@Column(columnDefinition = "longblob")
	private byte[] image;
	
	private String encodeImage;
	
	private int bidingStartingAmount;
	
	private String buyerUserName;
	
	private int buyerBid;
	
	private int status;
	
	@Temporal(TemporalType.DATE)
	private Date modified;
	
	@Temporal(TemporalType.DATE)
	private Date created;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public int getBidingStartingAmount() {
		return bidingStartingAmount;
	}

	public void setBidingStartingAmount(int bidingStartingAmount) {
		this.bidingStartingAmount = bidingStartingAmount;
	}

	public String getBuyerUserName() {
		return buyerUserName;
	}

	public void setBuyerUserName(String buyerUserName) {
		this.buyerUserName = buyerUserName;
	}

	public int getBuyerBid() {
		return buyerBid;
	}

	public void setBuyerBid(int buyerBid) {
		this.buyerBid = buyerBid;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
	
	

	public String getEncodeImage() {
		return encodeImage;
	}

	public void setEncodeImage(String encodeImage) {
		this.encodeImage = encodeImage;
	}



	@Override
	public String toString() {
		return "AuctionItem [id=" + id + ", productname=" + productname + ", email=" + email + ", image="
				+ Arrays.toString(image) + ", encodeImage=" + encodeImage + ", bidingStartingAmount="
				+ bidingStartingAmount + ", buyerUserName=" + buyerUserName + ", buyerBid=" + buyerBid + ", status="
				+ status + ", modified=" + modified + ", created=" + created + "]";
	}

	public AuctionItem(int id, String productname, String email, byte[] image, String encodeImage,
			int bidingStartingAmount, String buyerUserName, int buyerBid, int status, Date modified, Date created) {
		super();
		this.id = id;
		this.productname = productname;
		this.email = email;
		this.image = image;
		this.encodeImage = encodeImage;
		this.bidingStartingAmount = bidingStartingAmount;
		this.buyerUserName = buyerUserName;
		this.buyerBid = buyerBid;
		this.status = status;
		this.modified = modified;
		this.created = created;
	}

	public AuctionItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
