package kodlamaio.HRMS.business.abstracts;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.entities.concretes.City;

public interface CityService {
	
	DataResult<City> getById(int id);
	
}
