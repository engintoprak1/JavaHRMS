package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.JobAdvertisement;
import kodlamaio.HRMS.entities.dtos.JobAdvertisementForAddDto;

public interface JobAdvertisementService {
	
	Result add(JobAdvertisementForAddDto jobAdvertisement);
	
	DataResult<List<JobAdvertisement>> getAll();
	
	DataResult<List<JobAdvertisement>> getByIsActiveTrue();
	
	DataResult<List<JobAdvertisement>> getByIsActiveTrueOrderByApplicationDeadline();
	
	DataResult<List<JobAdvertisement>> getByIsActiveTrueAndEmployer_UserId(int employer_id);
	
	Result closeAdvertisement(int id, int userId);
	
	DataResult<List<JobAdvertisement>> findByApprovedTrueAndIsActiveTrue();

}
