package com.example.demo_elasticsearch.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.example.demo_elasticsearch.entity.EmployeeEntity;

@Repository
public interface EmployeeRepository extends ElasticsearchRepository<EmployeeEntity, String>{

}
