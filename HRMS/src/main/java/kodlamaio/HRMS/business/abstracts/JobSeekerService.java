package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.JobSeeker;
import kodlamaio.HRMS.entities.dtos.JobSeekerForRegisterDto;

public interface JobSeekerService {
	
	DataResult<List<JobSeeker>> getAll();	
	
	Result registerForJobSeeker(JobSeekerForRegisterDto jobSeekerForRegisterDto);
	
	DataResult<JobSeeker> getById(int id);
	
	
}
