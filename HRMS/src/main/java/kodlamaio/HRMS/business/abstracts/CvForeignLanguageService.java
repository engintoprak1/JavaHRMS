package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.Cv;
import kodlamaio.HRMS.entities.dtos.JobSeekerForAddForeignLanguageDto;

public interface CvForeignLanguageService {
	
	Result range(List<JobSeekerForAddForeignLanguageDto> foreignLanguages, Cv cv);

}
