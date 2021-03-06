package com.tanawit.springcloud.department;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.tanawit.springcloud.employee.Employee;
import com.tanawit.springcloud.employee.EmployeeClient;

@Service
@RibbonClient("employee-service")
public class DepartmentService {
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	@Autowired
	EmployeeClient employeeClient;
	
	public List<Department> findAllDepartment() {
		return departmentRepository.findAll();
	}
	
	public List<Department> findByOrganizationId(String organizationId) {
		return departmentRepository.findByOrganizationId(organizationId);
	}
	
	@HystrixCommand(fallbackMethod = "findDepartmentByIdRecovery")
	public Department findDepartmentById(String id) {
		Optional<Department> department = departmentRepository.findById(id);
		
		department.ifPresent(d -> {
			List<Employee> employees = employeeClient.findEmployeeByDepartmentId(d.getId());
			d.setEmployees(employees);
		});
		
		return department.orElse(null);
	}
	
	protected Department findDepartmentByIdRecovery(String id) {
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
