package com.example.demo_elasticsearch.entity;

import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "employee_index")
public class EmployeeEntity {

	private String id;
	private String name;
	private String department;
	private String designation;

	private AddressEntity addressEntity;
}
