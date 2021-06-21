package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.entities.concretes.City;

public interface CityService {
	
	DataResult<List<City>> getAll();
	
	DataResult<City> getById(int id);
	
}
