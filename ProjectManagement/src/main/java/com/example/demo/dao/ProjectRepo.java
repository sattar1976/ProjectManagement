package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Project;

public interface ProjectRepo extends CrudRepository<Project, Long>{

	@Override
	List<Project> findAll();
	
}
