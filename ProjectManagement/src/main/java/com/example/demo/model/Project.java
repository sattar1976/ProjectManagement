package com.example.demo.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Project {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="project_seq")
	private Long projectID;
	

	@OneToMany(mappedBy = "project") // Project variable name is defined	
	private List<Employee> employees;
	
	public Project(String projctName, Date startDate, Date endDate) {
		super();
		this.projctName = projctName;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public Project() {
		super();
	}
	private String projctName;
	private Date startDate;
	private Date endDate;
	
	
	public String getProjctName() {
		return projctName;
	}
	public void setProjctName(String projctName) {
		this.projctName = projctName;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public Project(String projctName) {
		super();
		this.projctName = projctName;
		
	}	

}
