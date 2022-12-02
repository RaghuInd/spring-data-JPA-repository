package com.employee.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.app.dao.DepartmentRepository;
import com.employee.app.dao.EmployeeRepository;
import com.employee.app.entity.Department;
import com.employee.app.entity.Employee;

@RestController
public class DepartmentController {

	@Autowired
	DepartmentRepository departmentRepo;
	@Autowired
	EmployeeRepository employeeRepo;
	
	@PostMapping("department")
	public Department addDepartment(@RequestBody Department departmnet) {
	return this.departmentRepo.save(departmnet);	
	}
	@GetMapping("department/{id}")
	public Department getDepartmentById(@PathVariable Integer id) {
	return this.departmentRepo.findById(id).get();	
	}
	// add employee to dept
	@PostMapping("department/employee/{depId}/{empId}")
	public Department addEmployeeToDepartment(@PathVariable("depId") Integer depId,@PathVariable("empId") Integer id) {
		
		Optional<Employee> empOpt = this.employeeRepo.findById(id);
		if(empOpt.isEmpty())
		{
			// write exception logic
		}
		Optional<Department> deptOptional = this.departmentRepo.findById(depId);
		if(deptOptional.isEmpty())
		{
			// write exception logic
		}
		Department dept = deptOptional.get();
		Employee emp = empOpt.get();
		dept.getEmployees().add(emp);
		return this.departmentRepo.save(dept);		
	}
}
