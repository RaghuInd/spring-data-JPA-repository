package com.employee.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.app.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@RestController
public class EmployeeController {

	@PersistenceContext
	private EntityManager entityManager;

	@GetMapping("employee/{id}")
	public Employee getEmployee(@PathVariable("id") Integer id) {

		return this.entityManager.find(Employee.class, id);

	}

	@PostMapping("employee")
	@Transactional
	public String addEmployee(@RequestBody Employee employee) {

		this.entityManager.persist(employee);

		return "Employee Added";
	}

}
