package com.tanawit.springcloud.department;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface DepartmentRepository extends MongoRepository<Department, String> {
	List<Department> findByOrganizationId(String organizationId);
}
