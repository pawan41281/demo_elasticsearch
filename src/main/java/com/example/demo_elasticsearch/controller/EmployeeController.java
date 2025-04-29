package com.example.demo_elasticsearch.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_elasticsearch.entity.EmployeeEntity;
import com.example.demo_elasticsearch.service.EmployeeService;
import com.example.demo_elasticsearch.wrapper.ApiResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/v1/employees")
@Tag(description = "Employee API", name = "Employee API")
public class EmployeeController {

	private final EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService=employeeService;
	}
	
	@Operation(summary = "Save employee", description = "Save a new employee in the database")
	@PostMapping("/")
	public ResponseEntity<ApiResponse<EmployeeEntity>> save(@RequestBody EmployeeEntity employeeEntity) {
		employeeEntity = employeeService.save(employeeEntity);
		Map<String, Integer> map = new HashMap<>();
		map.put("recordCount", employeeEntity==null?0:1);
		ApiResponse<EmployeeEntity> apiResponse = new ApiResponse<>("success", employeeEntity==null?"Record not saved":"Record saved successfully", employeeEntity, map);
		return ResponseEntity.ok(apiResponse);
	}
	
	@Operation(summary = "Get employee by id",  description = "Fetches a employee using their ID")
	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<EmployeeEntity>> findById(@PathVariable String id) {
		EmployeeEntity employeeEntity = employeeService.find(id);
		Map<String, Integer> map = new HashMap<>();
		map.put("recordCount", employeeEntity==null?0:1);
		ApiResponse<EmployeeEntity> apiResponse = new ApiResponse<>("success", employeeEntity==null?"Record not found":"Record retrieved successfully", employeeEntity, map);
		return ResponseEntity.ok(apiResponse);
	}
	
	@Operation(summary = "Get all employees", description = "Fetches all employees from database")
	@GetMapping("/")
	public ResponseEntity<ApiResponse<List<EmployeeEntity>>> findAll(
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size){
		Pageable pageable = PageRequest.of(page, size);
		List<EmployeeEntity> list = employeeService.findAll(pageable);
		Map<String, Integer> map = new HashMap<>();
		map.put("recordCount", list.size());
		ApiResponse<List<EmployeeEntity>> apiResponse = new ApiResponse<>("success", "Record retrieved successfully", list, map);
		return ResponseEntity.ok(apiResponse);
	}
	
	@Operation(summary = "Delete employee", description = "Delete an existing employee from the database")
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse<EmployeeEntity>> delete(@PathVariable String id){
		EmployeeEntity employeeEntity = employeeService.delete(id);
		Map<String, Integer> map = new HashMap<>();
		map.put("recordCount", employeeEntity==null?0:1);
		ApiResponse<EmployeeEntity> apiResponse = new ApiResponse<>("success", employeeEntity==null?"Record not found":"Record deleted successfully", employeeEntity, map);
		return ResponseEntity.ok(apiResponse);
	}
}
