package com.tanawit.springcloud.organization;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.tanawit.springcloud.department.Department;
import com.tanawit.springcloud.employee.Employee;

import lombok.Data;

@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Organization {
	@Id
	private String id;
	private String name;
	private String address;
	private List<Department> departments;
	private List<Employee> employees;
}
