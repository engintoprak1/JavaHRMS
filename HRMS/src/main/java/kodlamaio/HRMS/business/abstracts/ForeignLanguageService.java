package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.entities.concretes.ForeignLanguage;
import kodlamaio.HRMS.entities.dtos.ForeignLanguageWithDetailsDto;

public interface ForeignLanguageService {
	
	DataResult<ForeignLanguage> getById(int id);
	
	DataResult<List<ForeignLanguageWithDetailsDto>> getByCvId_cvId(int id);
	
	DataResult<List<ForeignLanguage>> getAll();

}
