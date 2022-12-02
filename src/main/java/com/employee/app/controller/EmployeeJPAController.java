package com.employee.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.app.entity.Employee;
import com.employee.app.service.EmployeeService;

//@RestController
//@RequestMapping("jpa")
public class EmployeeJPAController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("employee")
	public Employee addEmployee(@RequestBody Employee employee) {

		return this.employeeService.addEmployee(employee);

	}

	@GetMapping("employee/{id}")
	public Employee getEmployeeById(@PathVariable("id") Integer employeeId) {

		return this.employeeService.getEmployeeById(employeeId);

	}
	
	@GetMapping("employees")
	public List<Employee> getAllEmployee() {

		return this.employeeService.getAllEmployees();

	}

	
	@PutMapping("employee")
	public Employee updateEmployee(@RequestBody Employee updateEmployee) {

		return this.employeeService.updateEmployee(updateEmployee);

	}
	
	
	@DeleteMapping("employee/{id}")
	public Employee deleteEmployeeById(@PathVariable("id") Integer employeeId) {

		return this.employeeService.deleteEmployeeById(employeeId);

	}
}
