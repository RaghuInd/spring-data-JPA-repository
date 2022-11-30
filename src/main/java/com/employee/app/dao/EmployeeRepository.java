package com.employee.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.employee.app.entity.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	@Query("SELECT emp FROM Employee emp")
	List<Employee> findAllEmployee();
	
	@Query("SELECT emp FROM Employee emp WHERE emp.id = ?1")
	Employee findEmployeeById(Integer id);
	
	@Modifying
	@Query("UPDATE Employee emp SET emp.name = :empName WHERE emp.id = :id")
	void updateEmployeeNameById(@Param("id") Integer empId,String empName);
	
	// Query methods
	List<Employee> findBySalaryBetween(Double slaryFrom,Double salaryTo);

	List<Employee> findByNameLike(String empName);//1. name starts with parameter 2.name ends with parameter 3.parameter is a substring
	List<Employee> findByNameContaining(String empName);
}
