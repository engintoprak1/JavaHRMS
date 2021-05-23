package kodlamaio.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HRMS.business.abstracts.SystemEmployeeService;
import kodlamaio.HRMS.entities.concretes.SystemEmployee;

@RestController
@RequestMapping("/api/systemEmployees")
public class SystemEmployeesController {
	
	private SystemEmployeeService employeeService;
	
	@Autowired
	public SystemEmployeesController(SystemEmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	} 
	
	@GetMapping("/getall")
	public List<SystemEmployee> getAll(){
		return this.employeeService.getAll();
	}
	
}
