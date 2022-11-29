package com.employee.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.app.dao.EmployeeRepository;
import com.employee.app.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee getEmployeeById(Integer id) {

		Optional<Employee> optEmp = this.employeeRepository.findById(id);

		if (optEmp.isPresent())
			return optEmp.get();

		return null;
	}

	@Override
	public Employee addEmployee(Employee newEmployee) {
		return this.employeeRepository.save(newEmployee);
	}

	@Override
	public List<Employee> getAllEmployees() {

		return this.employeeRepository.findAll();
	}

	@Override
	public Employee updateEmployee(Employee updateEmployee) {

		return this.employeeRepository.save(updateEmployee);
	}

	@Override
	public Employee deleteEmployeeById(Integer employeeId) {

		Optional<Employee> deleteeEmployeeOpt = this.employeeRepository.findById(employeeId);
		if (deleteeEmployeeOpt.isEmpty())
			return null;
		this.employeeRepository.deleteById(employeeId);
		return deleteeEmployeeOpt.get();
	}

}
