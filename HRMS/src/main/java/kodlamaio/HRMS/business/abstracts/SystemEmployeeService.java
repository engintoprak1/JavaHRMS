package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.entities.concretes.SystemEmployee;

public interface SystemEmployeeService {
	DataResult<List<SystemEmployee>> getAll();
}
