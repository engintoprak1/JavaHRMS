package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.ForeignLanguageService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.dataAccess.abstracts.ForeignLanguageDao;
import kodlamaio.HRMS.entities.concretes.ForeignLanguage;
import kodlamaio.HRMS.entities.dtos.ForeignLanguageWithDetailsDto;

@Service
public class ForeignLanguageManager implements ForeignLanguageService{
	
	private ForeignLanguageDao foreignLanguageDao;
	
	@Autowired
	public ForeignLanguageManager(ForeignLanguageDao foreignLanguageDao) {
		super();
		this.foreignLanguageDao = foreignLanguageDao;
	}

	@Override
	public DataResult<ForeignLanguage> getById(int id) {
		return new SuccessDataResult<ForeignLanguage>(foreignLanguageDao.findById(id));
	}

	
	@Override
	public DataResult<List<ForeignLanguageWithDetailsDto>> getByCvId_cvId(int id) {
		return new SuccessDataResult<List<ForeignLanguageWithDetailsDto>>(foreignLanguageDao.findByCvId_cvId(id));
	}

	@Override
	public DataResult<List<ForeignLanguage>> getAll() {
		List<ForeignLanguage> foreignLanguages = this.foreignLanguageDao.findAll();
		return new SuccessDataResult<List<ForeignLanguage>>(foreignLanguages);
	}	
	
}
