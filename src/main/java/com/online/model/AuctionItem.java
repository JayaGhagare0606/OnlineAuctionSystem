package com.online.model;

import java.util.Arrays;
import java.util.Date;

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
	
	private String fullname;
	
	private String email;
	
	@Lob
	private byte[] image;
	
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

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
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

	public AuctionItem(int id, String fullname, String email, byte[] image, int status, Date modified, Date created) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.email = email;
		this.image = image;
		this.status = status;
		this.modified = modified;
		this.created = created;
	}

	public AuctionItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "AuctionItem [id=" + id + ", fullname=" + fullname + ", email=" + email + ", image="
				+ Arrays.toString(image) + ", status=" + status + ", modified=" + modified + ", created=" + created
				+ "]";
	}

}
