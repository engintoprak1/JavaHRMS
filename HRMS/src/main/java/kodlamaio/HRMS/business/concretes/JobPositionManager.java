package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.JobPositionService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.ErrorResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.JobPositionDao;
import kodlamaio.HRMS.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService{
	
	private JobPositionDao jobPositionDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>(jobPositionDao.findAll(),"Listelendi.");
	}

	@Override
	public Result add(JobPosition jobPosition) {
		
		if(isJobPositionExists(jobPosition).isSuccess() == false) {
			return new ErrorResult("Bu iş pozisyonu sistemde mevcut.");
		}
		
		jobPositionDao.save(jobPosition);
		return new SuccessResult("İş pozisyonu eklendi.");
		
	}
	
	private Result isJobPositionExists(JobPosition jobPosition) {
		if(jobPositionDao.findByPositionName(jobPosition.getPositionName()) != null) {
			return new ErrorResult();
		}
		
		return new SuccessResult();
	}

}
