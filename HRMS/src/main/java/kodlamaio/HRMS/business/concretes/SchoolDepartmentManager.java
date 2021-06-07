package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.JobSeekerSchoolDepartmentService;
import kodlamaio.HRMS.business.abstracts.JobSeekerService;
import kodlamaio.HRMS.business.abstracts.SchoolDepartmentService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.SchoolDepartmentDao;
import kodlamaio.HRMS.entities.concretes.JobSeekerSchoolDepartment;
import kodlamaio.HRMS.entities.dtos.JobSeekerForAddSchoolDepartmentDto;
import kodlamaio.HRMS.entities.dtos.SchoolDepartmentWithDetailsDto;

@Service
public class SchoolDepartmentManager implements SchoolDepartmentService{
	
	private SchoolDepartmentDao schoolDepartmentDao;
	private JobSeekerSchoolDepartmentService jobSeekerSchoolDepartmentService;
	private JobSeekerService jobSeekerService;
	
	@Autowired
	public SchoolDepartmentManager(SchoolDepartmentDao schoolDepartmentDao,JobSeekerSchoolDepartmentService jobSeekerSchoolDepartmentService,JobSeekerService jobSeekerService) {
		super();
		this.schoolDepartmentDao = schoolDepartmentDao;
		this.jobSeekerSchoolDepartmentService = jobSeekerSchoolDepartmentService;
		this.jobSeekerService = jobSeekerService;
	}

	@Override
	public DataResult<List<SchoolDepartmentWithDetailsDto>> findByJobSeekerSchoolDepartments_JobSeeker_UserId(int id) {
		
		return new SuccessDataResult<List<SchoolDepartmentWithDetailsDto>>(schoolDepartmentDao.findByJobSeekerSchoolDepartments_JobSeeker_userId(id));
		
	}

	@Override
	public Result assignToJobSeeker(JobSeekerForAddSchoolDepartmentDto schoolDepartment) {
		
		this.jobSeekerSchoolDepartmentService.add(new JobSeekerSchoolDepartment(
				jobSeekerService.getById(schoolDepartment.getJobSeeker().getUserId()).getData(),
				this.schoolDepartmentDao.getOne(schoolDepartment.getSchoolDepartment().getDepartmentId()),
				schoolDepartment.getSchoolStartDate(),
				schoolDepartment.getGraduationDate()
				));
		return new SuccessResult();
	}

	

}
