package com.employee.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.employee.app.entity.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	@Query("SELECT emp FROM Employee emp")
	List<Employee> findAllEmployee();
	@Query("SELECT emp FROM Employee emp WHERE emp.id = ?1")
	Employee findEmployeeById(Integer id);
}