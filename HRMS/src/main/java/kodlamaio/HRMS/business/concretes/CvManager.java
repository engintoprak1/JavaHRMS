package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.CvForeignLanguageService;
import kodlamaio.HRMS.business.abstracts.CvService;
import kodlamaio.HRMS.business.abstracts.CvSkillService;
import kodlamaio.HRMS.business.abstracts.ForeignLanguageService;
import kodlamaio.HRMS.business.abstracts.JobExperienceService;
import kodlamaio.HRMS.business.abstracts.JobSeekerService;
import kodlamaio.HRMS.business.abstracts.SchoolDepartmentService;
import kodlamaio.HRMS.business.abstracts.SkillService;
import kodlamaio.HRMS.core.utilities.files.FileService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.ErrorDataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.CvDao;
import kodlamaio.HRMS.entities.concretes.Cv;
import kodlamaio.HRMS.entities.concretes.JobSeeker;
import kodlamaio.HRMS.entities.dtos.CvWithDetailsDto;
import kodlamaio.HRMS.entities.dtos.JobSeekerForAddCvDto;

@Service
public class CvManager implements CvService{
	
	private CvDao cvDao;
	private SchoolDepartmentService schoolDepartmentService;
	private JobExperienceService jobExperienceService;
	private ForeignLanguageService foreignLanguageService;
	private SkillService skillService;
	private JobSeekerService jobSeekerService;
	private FileService fileService;
	private CvForeignLanguageService cvForeignLanguageService;
	private CvSkillService cvSkillService;
	
	@Autowired
	public CvManager(CvDao cvDao,SchoolDepartmentService schoolDepartmentService,JobExperienceService jobExperienceService,ForeignLanguageService foreignLanguageService,
			SkillService skillService,JobSeekerService jobSeekerService,FileService fileService,CvForeignLanguageService cvForeignLanguageService,CvSkillService cvSkillService) {
		super();
		this.cvDao = cvDao;
		this.schoolDepartmentService = schoolDepartmentService;
		this.jobExperienceService = jobExperienceService;
		this.foreignLanguageService = foreignLanguageService;
		this.skillService = skillService;
		this.jobSeekerService = jobSeekerService;
		this.fileService = fileService;
		this.cvForeignLanguageService = cvForeignLanguageService;
		this.cvSkillService = cvSkillService;
		
	}

	@Override
	public DataResult<CvWithDetailsDto> getCvWithDetails(int id) {
		CvWithDetailsDto cv = this.cvDao.findCvWithDetailsById(id);
		
		if(cv==null) {
			return new ErrorDataResult<CvWithDetailsDto>();
		}
		
		cv.setSchoolDepartments(this.schoolDepartmentService.findByJobSeekerSchoolDepartments_JobSeeker_UserId(cv.getJobSeeker().getUserId()).getData());
		
		cv.setJobExperiences(this.jobExperienceService.getByCv_id(cv.getId()).getData());
		
		cv.setForeignLanguages(this.foreignLanguageService.getByCvId_cvId(id).getData());
		
		cv.setSkills(this.skillService.getByCv_Id(cv.getId()).getData());
		
		return new SuccessDataResult<CvWithDetailsDto>(cv);
		
	}

	@Override
	public DataResult<List<Cv>> getAll() {
		return new SuccessDataResult<List<Cv>>(cvDao.findAll());
	}

	@Override
	public Result add(JobSeekerForAddCvDto cv) {
		
		JobSeeker jobSeeker = this.jobSeekerService.getById(cv.getJobSeekerId()).getData();
		
		Cv cvToAdd = new Cv(this.fileService.upload(cv.getPhoto()),cv.getGithubAdress(),cv.getLinkedinAdress(),cv.getCoverLetter(),jobSeeker);
		
		cvDao.save(cvToAdd);
		
		this.cvForeignLanguageService.range(cv.getForeignLanguages(), cvToAdd);
		this.jobExperienceService.range(cv.getJobExperiences(), cvToAdd);
		this.cvSkillService.range(cv.getSkills(), cvToAdd);
		
		return new SuccessResult("Cv kaydedildi.");
				
				
	}

	
}
