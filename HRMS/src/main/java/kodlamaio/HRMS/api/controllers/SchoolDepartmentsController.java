package kodlamaio.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HRMS.business.abstracts.SchoolDepartmentService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.dtos.JobSeekerForAddSchoolDepartmentDto;
import kodlamaio.HRMS.entities.dtos.SchoolDepartmentWithDetailsDto;



@RestController
@RequestMapping("/api/schoolDepartments")
public class SchoolDepartmentsController {

	private SchoolDepartmentService schoolDepartmentService;
	
	@Autowired
	public SchoolDepartmentsController(SchoolDepartmentService schoolDepartmentService) {
		super();
		this.schoolDepartmentService = schoolDepartmentService;
	}


	@GetMapping("/getByUserId")
	public DataResult<List<SchoolDepartmentWithDetailsDto>> getByUserId(int id){
		return schoolDepartmentService.findByJobSeekerSchoolDepartments_JobSeeker_UserId(id);
	}
	
	@PostMapping("/assignToUser")
	public Result assignToUser(@RequestBody JobSeekerForAddSchoolDepartmentDto schoolDepartment) {
		return this.schoolDepartmentService.assignToJobSeeker(schoolDepartment);
	}
}
