package com.employee.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.app.dao.EmployeeRepository;
import com.employee.app.dao.ProjectRepository;
import com.employee.app.entity.Employee;
import com.employee.app.entity.Project;

@RestController
public class ProjectController {

	@Autowired
	private ProjectRepository projectRepo;
	@Autowired
	private EmployeeRepository employeeRepo;

	@PostMapping("project")
	public Project addProject(@RequestBody Project project) {
		return this.projectRepo.save(project);
	}
	

	@GetMapping("project/{projectId}")
	public Project getProjectById(@PathVariable Integer projectId) {
		return this.projectRepo.findById(projectId).get();
	}

	@PostMapping("project/employee/{projectId}/{empId}")
	public Project addEmployeeProjectByIds(@PathVariable("projectId") Integer projectId,
			@PathVariable("empId") Integer employeeId) {
		Optional<Project> optPrj = this.projectRepo.findById(projectId);
		if (optPrj.isEmpty()) {
			// do exception hadling
		}
		Optional<Employee> optEmp = this.employeeRepo.findById(employeeId);
		if (optEmp.isEmpty()) {
			// do exception hadling
		}

		Project project = optPrj.get();
		Employee employee = optEmp.get();
		project.getEmployees().add(employee);

		return this.projectRepo.save(project);
	}

}
