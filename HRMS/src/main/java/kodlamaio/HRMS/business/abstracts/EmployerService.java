package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.Employer;
import kodlamaio.HRMS.entities.concretes.dtos.EmployerForRegisterDto;

public interface EmployerService {
	DataResult<List<Employer>> getAll();
	
	Result register(EmployerForRegisterDto employer);
	
	DataResult<Employer> getById(int id);
}
