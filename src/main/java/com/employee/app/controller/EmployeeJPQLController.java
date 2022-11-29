package com.employee.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.app.dao.EmployeeRepository;
import com.employee.app.entity.Employee;

@RestController
@RequestMapping("jpql")
public class EmployeeJPQLController {

	@Autowired
	private EmployeeRepository empRepo;
	
	@GetMapping("employees")
	public List<Employee> getAllEmployees(){
		return this.empRepo.findAllEmployee();
	}
	@GetMapping("employee/{id}")
	public Employee getEmployeeByid(@PathVariable("id") Integer id){
		return this.empRepo.findEmployeeById(id);
	}
}
