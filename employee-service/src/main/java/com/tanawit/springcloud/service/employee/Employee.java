package com.tanawit.springcloud.service.employee;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Employee {
	@Id
	private String id;
	private String name;
	private int age;
	private String position;
	private String organizationId;
	private String departmentId;
}
