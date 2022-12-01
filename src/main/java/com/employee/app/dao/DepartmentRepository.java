package com.employee.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.app.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{

}
