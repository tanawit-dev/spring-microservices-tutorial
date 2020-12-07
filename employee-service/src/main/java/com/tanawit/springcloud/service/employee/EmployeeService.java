package com.tanawit.springcloud.service.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> findAllEmployee() {
		return employeeRepository.findAll();
	}
	
	public Employee findEmployeeById(String id) {
		return employeeRepository.findById(id).orElse(null);
	}
	
	public List<Employee> findEmployeeByDepartmentId(String departmentId) {
		return employeeRepository.findByDepartmentId(departmentId);
	}
	
	public List<Employee> findEmployeeByOrganizationId(String organizationId) {
		return employeeRepository.findByOrganizationId(organizationId);
	}
	
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public Employee updateEmployee(String id, Employee employee) {
		employeeRepository.findById(employee.getId()).ifPresent(e -> employee.setId(e.getId()));
		return employeeRepository.save(employee);
	}
	
	public void deleteEmployeeById(String id) {
		employeeRepository.deleteById(id);
	}
}
