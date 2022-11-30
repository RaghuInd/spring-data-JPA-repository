package com.employee.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.app.dao.AddressRepository;
import com.employee.app.dao.EmployeeRepository;
import com.employee.app.entity.Address;
import com.employee.app.entity.Employee;

@RestController
public class AddressController {

	@Autowired
	private AddressRepository addressRepo;

	@Autowired
	private EmployeeRepository employeeRepo;

	@PostMapping("address/{empId}")
	public Address addAddressToEmployeeById(@RequestBody Address address, @PathVariable Integer empId) {
		
		Address newAddress = this.addressRepo.save(address);
		
		Optional<Employee> foundEmployeeOpt = this.employeeRepo.findById(empId);
		
		if (foundEmployeeOpt.isPresent()) {
			Employee emp = foundEmployeeOpt.get();
			emp.setAddress(newAddress);
			this.employeeRepo.save(emp);
		}
		return newAddress;
	}
	
}
