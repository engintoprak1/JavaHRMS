package kodlamaio.HRMS.business.concretes;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.CityService;
import kodlamaio.HRMS.business.abstracts.EmployerService;
import kodlamaio.HRMS.business.abstracts.JobAdvertisementService;
import kodlamaio.HRMS.business.abstracts.JobPositionService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.ErrorResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.HRMS.entities.concretes.JobAdvertisement;
import kodlamaio.HRMS.entities.dtos.JobAdvertisementForAddDto;

@Service
public class JobAdvertisementManager implements JobAdvertisementService{
	
	private JobAdvertisementDao jobAdvertisementDao;
	private CityService cityService;
	private JobPositionService jobPositionService;
	private EmployerService employerService;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao,CityService cityService, JobPositionService jobPositionService, EmployerService employerService) {
		this.jobAdvertisementDao = jobAdvertisementDao;
		this.cityService = cityService;
		this.jobPositionService = jobPositionService;
		this.employerService = employerService;
	}

	@Override
	public Result add(JobAdvertisementForAddDto jobAdvertisement) {
		
		if(!isEmployerExists(jobAdvertisement.getEmployerId()).isSuccess()) {
			return new ErrorResult("Böyle bir işveren yok.");
		}if(!isMaxBiggerThanMin(jobAdvertisement.getMaxSalary(),jobAdvertisement.getMinSalary()).isSuccess()) {
			return new ErrorResult("Minimum maaş maximum maaştan fazla olamaz.");
		}if(!isEndDateValid(jobAdvertisement.getApplicationDeadline()).isSuccess()) {
			return new ErrorResult("Bitiş tarihi başlangıç tarihinden geride olamaz.");
		}
		
		JobAdvertisement jobAdvertisementToAdd = new JobAdvertisement(jobAdvertisement.getJobDescription(), 
				jobAdvertisement.getMaxSalary(), 
				jobAdvertisement.getMinSalary(), 
				jobAdvertisement.getOpenPositionCount(),
				jobAdvertisement.getApplicationDeadline(),
				true,
				cityService.getById(jobAdvertisement.getCityId()).getData(),
				jobPositionService.getById(jobAdvertisement.getJobPositionId()).getData(),
				employerService.getById(jobAdvertisement.getEmployerId()).getData(),
				jobAdvertisement.getWorkingTime());
      
				
		jobAdvertisementDao.save(jobAdvertisementToAdd);
		
		return new SuccessResult("İş ilanı başarıyla oluşturuldu.");
	}
	
	
	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.findAll(),"Listelendi.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveTrue() {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.findByIsActiveTrue());
	}
	
	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveTrueOrderByApplicationDeadline() {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.findByIsActiveTrueOrderByApplicationDeadline());
	}
	
	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveTrueAndEmployer_UserId(int userId) {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.findByIsActiveTrueAndEmployer_UserId(userId));
	}
	
	@Override
	public Result closeAdvertisement(int id, int userId) {
		JobAdvertisement jobAdvertisement = jobAdvertisementDao.findByIdAndEmployer_UserId(id, userId);
		if(jobAdvertisement == null) {
			return new ErrorResult("Bu iş verenin böyle bir iş ilanı yok.");
		}
		jobAdvertisement.setActive(false);
		jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("İş ilanı başarıyla kaldırıldı.");
	}
	
	
	private Result isEmployerExists(int id) {
		if (id <= 0 || employerService.getById(id).getData() == null) {
			return new ErrorResult();
		}
		return new SuccessResult();
	}
	
	private Result isMaxBiggerThanMin(Double max,Double min) {
		
		if(min>=max) {
			return new ErrorResult();
		}
		return new SuccessResult();
		
	}
	
	private Result isEndDateValid(Date endDate) {
		
		if(new Date().compareTo(endDate) > 0) {
			return new ErrorResult();
		}
		return new SuccessResult();
		
	}

	

	

	

	
}
