package com.example.demo;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.EmployeeRepo;
import com.example.demo.dao.ProjectRepo;
import com.example.demo.model.Employee;
import com.example.demo.model.Project;

@RestController

public class Home {
	
	@Value("${versionMy}")
	private String versionApp;
	
	@GetMapping("/version")
	public String version()
	{
		return "Version Saved is"+versionApp;
	}
	

	@GetMapping("/saveProjectInfo")
	
	public String welcome(@RequestParam(value="projectName", required=false) String projectName, @RequestParam(value="startDate", required=false) String startDate, @RequestParam(value="endDate", required=false) String endDate)
	{
	
		Project project = new Project();
		project.setProjctName(projectName);
		//project.setStartDate(Date.valueOf(startDate));
		//project.setEndDate(Date.valueOf(endDate));
		
		repo.save(project);
		return "project info saved";
	}
	
	@GetMapping("/printProjects")

	public String printProjects()

	{
		List<Project> projects = repo.findAll();
		String projectInfoStr = "";
		
     for(int i=0; i < projects.size();i++ )
		projectInfoStr += i + ":"+ projects.get(i).getProjctName()+"<br>";
		
		return projectInfoStr;
	}
	
	@Autowired 
	ProjectRepo  repo;
	
	@Autowired 
	EmployeeRepo empRepo;
	 
	Project pr ;
	
@GetMapping("/saveEmployee")	
	public String saveEmps(@RequestParam(value="employeeName", required=false) String employeeName, @RequestParam(value="age", required=false) int age, @RequestParam(value="sex", required=false) char sex, @RequestParam(value="projectName") String projectName)
	{
	
		Employee employee = new Employee();
		employee.setName(employeeName);
		employee.setAge(age); 
		/*
		 * pr = new Project(projectName);
		 * 
		 * repo.save(pr);
		 */
		employee.setProject(pr);
		empRepo.save(employee);
		return "project info saved";
	}
	/*
	 * @GetMapping("saveEmpProject")
	 * 
	 * public String saveEmpProject(@RequestParam(value="empID") int
	 * empID, @RequestParam(value="projectID") long projectID) { Optional <Employee>
	 * emp =empRepo.findById(empID); Optional <Project> projectFound =
	 * repo.findById(projectID);
	 * 
	 * if(emp.isPresent()&& projectFound.isPresent()) {
	 * System.out.println("insideeeeeeeeeeeee"); Employee emp1 = emp.get();
	 * System.out.println("insideeeeeeeeeeeee"+emp1);
	 * 
	 * Project ppj = projectFound.get();
	 * System.out.println("insideeeeeeeeeeeee"+ppj);
	 * 
	 * emp1.setProject(ppj);
	 * 
	 * empRepo.save(emp1); } return "project employee relation saved"; }
	 */
}
//http://localhost:8080/saveProjectInfo?projectName=MustHaveProject&startDate=03-03-1978&endDate=05-05-1978

