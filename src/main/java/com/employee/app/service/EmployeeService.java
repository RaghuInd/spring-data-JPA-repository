package com.employee.app.service;

import java.util.List;

import com.employee.app.entity.Employee;

public interface EmployeeService {
	Employee getEmployeeById(Integer id);
	Employee addEmployee(Employee employee);
	List<Employee> getAllEmployees();
	Employee updateEmployee(Employee updateEmployee);
	Employee deleteEmployeeById(Integer employeeId);

}
