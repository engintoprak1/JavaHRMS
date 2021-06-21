package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.Cv;
import kodlamaio.HRMS.entities.dtos.JobSeekerForAddSkillDto;

public interface CvSkillService {
	
	Result range(List<JobSeekerForAddSkillDto> skills,Cv cv);
	
}
