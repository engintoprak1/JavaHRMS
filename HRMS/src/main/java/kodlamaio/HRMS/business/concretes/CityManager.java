package kodlamaio.HRMS.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.CityService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.ErrorDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.dataAccess.abstracts.CityDao;
import kodlamaio.HRMS.entities.concretes.City;

@Service
public class CityManager implements CityService{
	
	CityDao cityDao;
	
	@Autowired
	public CityManager(CityDao cityDao) {
		this.cityDao = cityDao;
	}

	@Override
	public DataResult<City> getById(int id) {
		City city = cityDao.findById(id);
		
		if(city == null) {
			return new ErrorDataResult<City>();
		}
		
		return new SuccessDataResult<City>(city);
		
	}

}
