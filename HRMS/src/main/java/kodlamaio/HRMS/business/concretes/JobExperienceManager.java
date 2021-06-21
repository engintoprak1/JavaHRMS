
package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.JobExperienceService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.JobExperienceDao;
import kodlamaio.HRMS.entities.concretes.Cv;
import kodlamaio.HRMS.entities.concretes.JobExperience;
import kodlamaio.HRMS.entities.dtos.JobSeekerForAddJobExperienceDto;

@Service
public class JobExperienceManager implements JobExperienceService{
	
	private JobExperienceDao jobExperienceDao;
	
	@Autowired
	public JobExperienceManager(JobExperienceDao jobExperienceDao) {
		super();
		this.jobExperienceDao = jobExperienceDao;
	}

	@Override
	public DataResult<List<JobExperience>> getByCv_id(int id) {
		return new SuccessDataResult<List<JobExperience>>(jobExperienceDao.findByCv_idOrderByDepartureDateDesc(id));
	}

	@Override
	public Result add(JobSeekerForAddJobExperienceDto jobExperience, Cv cv) {
		JobExperience jobExperienceToAdd = new JobExperience(jobExperience.getWorkplaceName(),jobExperience.getPosition(),jobExperience.getJobStartDate(),jobExperience.getDepartureDate(),cv);
		jobExperienceDao.save(jobExperienceToAdd);
		return new SuccessResult();
	}
	

	@Override
	public Result range(List<JobSeekerForAddJobExperienceDto> jobExperiences, Cv cv) {
		for(JobSeekerForAddJobExperienceDto jobExperience : jobExperiences) {
			JobExperience jobExperienceToAdd = new JobExperience(jobExperience.getWorkplaceName(),jobExperience.getPosition(),jobExperience.getJobStartDate(),jobExperience.getDepartureDate(),cv);
			jobExperienceDao.save(jobExperienceToAdd);
		}
		return new SuccessResult();
	}

	
}
