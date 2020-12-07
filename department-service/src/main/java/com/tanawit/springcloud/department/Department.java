package com.tanawit.springcloud.department;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.tanawit.springcloud.employee.Employee;

import lombok.Data;

@Data
@Document
public class Department {
	private String id;
	private String name;
	private String organizationId;
	private List<Employee> employees;	
}
