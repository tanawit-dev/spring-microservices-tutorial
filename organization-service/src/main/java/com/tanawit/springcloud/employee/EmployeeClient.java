package com.tanawit.springcloud.employee;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("employee-service")
public interface EmployeeClient {

	@GetMapping("/employees/organization/{organizationId}")
	public List<Employee> findEmployeeByOrganizationId(@PathVariable String organizationId);

}
