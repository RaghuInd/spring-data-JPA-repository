package com.employee.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.app.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer>{

}
