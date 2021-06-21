package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.CvForeignLanguageService;
import kodlamaio.HRMS.business.abstracts.ForeignLanguageService;
import kodlamaio.HRMS.core.utilities.results.ErrorResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.CvForeignLanguageDao;
import kodlamaio.HRMS.entities.concretes.Cv;
import kodlamaio.HRMS.entities.concretes.CvForeignLanguage;
import kodlamaio.HRMS.entities.dtos.JobSeekerForAddForeignLanguageDto;

@Service
public class CvForeignLanguageManager implements CvForeignLanguageService{
	
	private CvForeignLanguageDao cvForeignLanguageDao;
	private ForeignLanguageService foreignLanguageService;
	
	@Autowired
	public CvForeignLanguageManager(CvForeignLanguageDao cvForeignLanguageDao,ForeignLanguageService foreignLanguageService) {
		super();
		this.cvForeignLanguageDao = cvForeignLanguageDao;
		this.foreignLanguageService = foreignLanguageService;
	}

	@Override
	public Result range(List<JobSeekerForAddForeignLanguageDto> foreignLanguages, Cv cv) {
		for(JobSeekerForAddForeignLanguageDto foreignLanguage : foreignLanguages) {
			
			if(!checkIfLanguageExistsInDatabase(foreignLanguage.getForeignLanguage().getId()).isSuccess()){
				return new SuccessResult("Bu dil sistemde mevcut.");
			}
			
			CvForeignLanguage cvForeignLanguage = new CvForeignLanguage(cv,foreignLanguage.getForeignLanguage(),foreignLanguage.getLevel());
			
			cvForeignLanguageDao.save(cvForeignLanguage);
			
		}
		return new SuccessResult();
	}
	
	private Result checkIfLanguageExistsInDatabase(int id) {
		if (foreignLanguageService.getById(id) == null) {
			return new ErrorResult();
		}
		return new SuccessResult();
	}

	

	

}
