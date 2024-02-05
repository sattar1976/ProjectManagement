package com.example.demo.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Employee;

public interface EmployeeRepo extends CrudRepository<Employee, Integer>{
	@Override
		Optional<Employee> findById(Integer id);
	
}

