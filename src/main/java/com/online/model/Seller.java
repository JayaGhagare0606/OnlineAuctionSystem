package com.online.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Seller {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String fullname;
	private String email;
	private String mobile;
	private String password;
	private String dob;
	private int age;
	private String gender;
	private String address;
	private int pincode;
	private String city;
	private String state;
	private String country;
	private String type;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public Seller(int id, String fullname, String email, String mobile, String password, String dob, int age,
			String gender, String address, int pincode, String city, String state, String country, String type,
			int status, Date modified, Date created) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
		this.dob = dob;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.pincode = pincode;
		this.city = city;
		this.state = state;
		this.country = country;
		this.type = type;
		this.status = status;
		this.modified = modified;
		this.created = created;
	}

	public Seller() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Seller [id=" + id + ", fullname=" + fullname + ", email=" + email + ", mobile=" + mobile + ", password="
				+ password + ", dob=" + dob + ", age=" + age + ", gender=" + gender + ", address=" + address
				+ ", pincode=" + pincode + ", city=" + city + ", state=" + state + ", country=" + country + ", type="
				+ type + ", status=" + status + ", modified=" + modified + ", created=" + created + "]";
	}

}
