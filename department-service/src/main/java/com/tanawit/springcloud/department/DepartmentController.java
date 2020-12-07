package com.tanawit.springcloud.department;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("departments")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@GetMapping
	public List<Department> findAllDepartment() {
		return departmentService.findAllDepartment();
	}

	@GetMapping("/{id}")
	public Department findDepartment(@PathVariable String id) {
		return departmentService.findDepartmentById(id);
	}
	
	@GetMapping("organization/{organizationId}")
	public List<Department> findDepartmentByOrganizationId(@PathVariable String organizationId) {
		return departmentService.findByOrganizationId(organizationId);
	}
	
	@PostMapping
	public Department createDepartment(@RequestBody Department department) {
		return departmentService.createDepartment(department);
	}
	
	@PutMapping("/{id}")
	public Department updateDepartment(@PathVariable String id, @RequestBody Department department) {
		return departmentService.updateDepartment(id, department);
	}
	
	@DeleteMapping("/{id}")
	public void deleteDepartment(@PathVariable String id) {
		departmentService.deleteDepartment(id);
	}
	
}
