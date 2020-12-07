package com.tanawit.springcloud.department;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	public List<Department> findAllDepartment() {
		return departmentRepository.findAll();
	}
	
	public List<Department> findByOrganizationId(String organizationId) {
		return departmentRepository.findByOrganizationId(organizationId);
	}
	
	public Department findDepartmentById(String id) {
		return departmentRepository.findById(id).orElse(null);
	}
	
	public Department createDepartment(Department department) {
		return departmentRepository.save(department);
	}
	
	public Department updateDepartment(String id, Department department) {
		departmentRepository.findById(id).ifPresent(d -> department.setId(d.getId()));
		return departmentRepository.save(department);
	}
	
	public void deleteDepartment(String id) {
		departmentRepository.deleteById(id);
	}

}
