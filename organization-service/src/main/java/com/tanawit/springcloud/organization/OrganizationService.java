package com.tanawit.springcloud.organization;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.tanawit.springcloud.department.Department;
import com.tanawit.springcloud.department.DepartmentClient;
import com.tanawit.springcloud.employee.Employee;
import com.tanawit.springcloud.employee.EmployeeClient;

@Service
public class OrganizationService {
	
	@Autowired
	private OrganizationRepository organizationRepository;
	
	@Autowired
	private EmployeeClient employeeClient;
	
	@Autowired
	private DepartmentClient departmentClient;
	
	public List<Organization> findAllOrganization() {
		return organizationRepository.findAll();
	}
	
	@HystrixCommand(fallbackMethod = "findOraganizationByIdRecovery")
	public Organization findOraganizationById(String id) {
		Optional<Organization> organization = organizationRepository.findById(id);
		
		organization.ifPresent(o -> {
			List<Employee> employees = employeeClient.findEmployeeByOrganizationId(o.getId());
			List<Department> departments = departmentClient.findDepartmentByOrganizationId(o.getId());
			
			o.setEmployees(employees);
			o.setDepartments(departments);
		});
		
		return organization.orElse(null);
	}
	
	public Organization findOraganizationByIdRecovery(String id) {
		return organizationRepository.findById(id).orElse(null);
	}
	
	public Organization createOrganization(Organization organization) {
		return organizationRepository.save(organization);
	}
	
	public Organization updateOrganization(String id, Organization organization) {
		organizationRepository.findById(id).ifPresent(o -> organization.setId(o.getId()));
		return organizationRepository.save(organization);
	}
	
	public void deleteOrganization(String id) {
		organizationRepository.deleteById(id);
	}
}
