package com.example.demo_elasticsearch.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.example.demo_elasticsearch.entity.EmployeeEntity;

public interface EmployeeService {

	public EmployeeEntity save(EmployeeEntity employeeEntity);
	public List<EmployeeEntity> findAll(Pageable pageable);
	public EmployeeEntity find(String id);
	public EmployeeEntity delete(String id);
	
}
