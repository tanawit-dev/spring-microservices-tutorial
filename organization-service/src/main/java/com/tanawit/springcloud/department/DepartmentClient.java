package com.tanawit.springcloud.department;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("department-service")
public interface DepartmentClient {
	
	@GetMapping("/departments/organization/{organizationId}")
	public List<Department> findDepartmentByOrganizationId(@PathVariable String organizationId);
}
