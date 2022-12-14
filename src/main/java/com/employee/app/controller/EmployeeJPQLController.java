package com.employee.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.employee.app.dao.DepartmentRepository;
import com.employee.app.dao.EmployeeRepository;
import com.employee.app.entity.Department;
import com.employee.app.entity.Employee;
import com.employee.app.exception.EmployeeException;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
//@RequestMapping("v2") // used to do versioning of API
public class EmployeeJPQLController {

	@Autowired
	private EmployeeRepository empRepo;
	@Autowired
	private DepartmentRepository departmentRepo;

	@PostMapping("employee")
	public Employee addEmployee(@Valid @RequestBody Employee employee) {
		return this.empRepo.save(employee);
	}

	@PostMapping("employee/{deptId}")
	public Employee addEmployeeToDepartmentById(@Valid @RequestBody Employee employee,
			@PathVariable("deptId") Integer deptId) {

		Optional<Department> optDept = this.departmentRepo.findById(deptId);
		if (optDept.isEmpty()) {
			// handle exception
		}
		Department dept = optDept.get();
		employee.setDepartment(dept);
		return this.empRepo.save(employee);

	}

	@GetMapping("employees")
	public List<Employee> getAllEmployees() {
		return this.empRepo.findAllEmployee();
	}

	@GetMapping("employee/{id}")
	//@ResponseStatus(HttpStatus.ACCEPTED)
	public Employee getEmployeeByid(@PathVariable("id") Integer id) throws EmployeeException {
		//return this.empRepo.findEmployeeById(id);
		Optional<Employee> optEmp = this.empRepo.findById(id);
		if(optEmp.isEmpty())
			throw new EmployeeException("Employee id does not exists:"+id);
		
		return optEmp.get();
	}

	@GetMapping("employee/department/{id}")
	public Department getDepartmentOfEmployeeByid(@PathVariable("id") Integer id) {
		return this.empRepo.findEmployeeById(id).getDepartment();
	}
	
	@PatchMapping("employee/{id}/{name}")
	@Transactional
	public String updateEmployeeNameByid(@PathVariable("id") Integer id, @PathVariable("name") String name) {
		this.empRepo.updateEmployeeNameById(id, name);
		return "Employee name updated.";
	}

	@GetMapping("employee/{from}/{to}")
	@Transactional
	public List<Employee> getEmployeeBetweenSalry(@PathVariable Double from, @PathVariable("to") Double toSal) {

		return this.empRepo.findBySalaryBetween(from, toSal);
	}

	@GetMapping("employee/name/{name}")
	public List<Employee> getAllEmployeesByName(@PathVariable("name") String empName) {
		// return this.empRepo.findByNameLike(empName);
		return this.empRepo.findByNameContaining(empName);
	}

}
