package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.Cv;
import kodlamaio.HRMS.entities.dtos.CvWithDetailsDto;
import kodlamaio.HRMS.entities.dtos.JobSeekerForAddCvDto;

public interface CvService {
	
	DataResult<CvWithDetailsDto> getCvWithDetails(int id);
	
	DataResult<List<Cv>> getAll();
	
	Result add(JobSeekerForAddCvDto cv);
}
