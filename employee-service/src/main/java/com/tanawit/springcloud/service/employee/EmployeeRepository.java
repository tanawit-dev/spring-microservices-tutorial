package com.tanawit.springcloud.service.employee;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
	List<Employee> findByDepartmentId(String departmentId);
	List<Employee> findByOrganizationId(String organizationId);
}
