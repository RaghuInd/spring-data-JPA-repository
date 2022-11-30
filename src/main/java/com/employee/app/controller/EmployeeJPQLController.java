package com.employee.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.app.dao.EmployeeRepository;
import com.employee.app.entity.Employee;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("jpql")
public class EmployeeJPQLController {

	@Autowired
	private EmployeeRepository empRepo;
	
	@PostMapping("employee")
	public Employee addEmployee(@RequestBody Employee employee){
		return this.empRepo.save(employee);
	}
	@GetMapping("employees")
	public List<Employee> getAllEmployees(){
		return this.empRepo.findAllEmployee();
	}
	@GetMapping("employee/{id}")
	public Employee getEmployeeByid(@PathVariable("id") Integer id){
		return this.empRepo.findEmployeeById(id);
	}
	
	@PatchMapping("employee/{id}/{name}")
	@Transactional
	public String updateEmployeeNameByid(@PathVariable("id") Integer id,@PathVariable("name") String name){
		 this.empRepo.updateEmployeeNameById(id,name);
		 return "Employee name updated.";
	}
	
	@GetMapping("employee/{from}/{to}")
	@Transactional
	public List<Employee> getEmployeeBetweenSalry(@PathVariable Double from,@PathVariable("to") Double toSal){
		 
		 return this.empRepo.findBySalaryBetween(from,toSal);
	}
	@GetMapping("employee/name/{name}")
	public List<Employee> getAllEmployeesByName(@PathVariable("name") String empName){
		//return this.empRepo.findByNameLike(empName);
		return this.empRepo.findByNameContaining(empName);
	}
	
}
