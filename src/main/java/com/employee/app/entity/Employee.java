package com.employee.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="employees")
public class Employee {
	@Id
	@GeneratedValue
	private Integer id;
	@NotBlank(message = "Employee name can't be blank.")
	//@Size(min=3, max=30, message = "Name must be at least 3 and max 30 chars")
	@NotNull(message = "Employee name can't be null.")
	@Pattern(regexp="[A-Za-z]{3,30}", message= "Name must be alphabets having min 3 to max 30 chars.")
	private String name;
	@Min(value = 0,message = "Salary must be greater than 0.")	
	private Double salary;
	// employee has depencdency on Address
	
	@OneToOne
	private Address address;
	
	@ManyToOne
	@JsonIgnore
	private Department department;
	
	public Employee() {
		super();
	}
	public Employee(Integer id, String name, Double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	
	public Employee(Integer id, String name, Double salary, Address address, Department department) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.address = address;
		this.department = department;
	}
	
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
}
