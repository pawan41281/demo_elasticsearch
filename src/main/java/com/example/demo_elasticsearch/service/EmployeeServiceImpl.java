package com.example.demo_elasticsearch.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo_elasticsearch.entity.EmployeeEntity;
import com.example.demo_elasticsearch.repository.EmployeeRepository;


@Service
public class EmployeeServiceImpl implements EmployeeService{

	private final EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public EmployeeEntity save(EmployeeEntity employeeEntity) {
		return employeeRepository.save(employeeEntity);
	}

	@Override
	public List<EmployeeEntity> findAll(Pageable pageable) {
//		return (List<EmployeeEntity>) employeeRepository.findAll();
		
		Page<EmployeeEntity> employeePage = employeeRepository.findAll(pageable);
		List<EmployeeEntity> employeeList = employeePage.getContent();
		return employeeList;
		
	}

	@Override
	public EmployeeEntity find(String id) {
		return employeeRepository.findById(id).orElse(null);
	}

	@Override
	public EmployeeEntity delete(String id) {
		
		EmployeeEntity employeeEntity = find(id);
		if(employeeEntity!=null)
			employeeRepository.deleteById(id);
		
		return employeeEntity;
		
	}
}
