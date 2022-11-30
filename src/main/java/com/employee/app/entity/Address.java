package com.employee.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Address {
	@Id
	private Integer id;
	private String city;
	private String pincode;
	public Address() {
		super();
	}
	public Address(Integer id, String city, String pincode) {
		super();
		this.id = id;
		this.city = city;
		this.pincode = pincode;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	

}
