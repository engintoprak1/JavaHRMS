package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.Cv;
import kodlamaio.HRMS.entities.concretes.JobExperience;
import kodlamaio.HRMS.entities.dtos.JobSeekerForAddJobExperienceDto;

public interface JobExperienceService {
	
	DataResult<List<JobExperience>> getByCv_id(int id);
	
	Result add(JobSeekerForAddJobExperienceDto jobExperience, Cv cv);
	
	Result range(List<JobSeekerForAddJobExperienceDto> jobExperience,Cv cv);
}
