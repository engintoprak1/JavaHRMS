package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.dtos.JobSeekerForAddSchoolDepartmentDto;
import kodlamaio.HRMS.entities.dtos.SchoolDepartmentWithDetailsDto;

public interface SchoolDepartmentService {
	
	DataResult<List<SchoolDepartmentWithDetailsDto>> findByJobSeekerSchoolDepartments_JobSeeker_UserId(int id);

	Result assignToJobSeeker(JobSeekerForAddSchoolDepartmentDto schoolDepartment);
	
}
