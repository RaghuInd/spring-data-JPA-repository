package com.employee.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Address {
	@Id
	private Integer id;
	private String city;
	private String pincode;
	
	@OneToOne
	@JsonIgnore
	private Employee employee;
	
	public Address() {
		super();
	}
	public Address(Integer id, String city, String pincode) {
		super();
		this.id = id;
		this.city = city;
		this.pincode = pincode;
	}
	
	
	public Address(Integer id, String city, String pincode, Employee employee) {
		super();
		this.id = id;
		this.city = city;
		this.pincode = pincode;
		this.employee = employee;
	}
	
	
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
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
