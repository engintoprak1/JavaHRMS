package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.CvSkillService;
import kodlamaio.HRMS.core.utilities.results.ErrorResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.CvSkillDao;
import kodlamaio.HRMS.entities.concretes.Cv;
import kodlamaio.HRMS.entities.concretes.CvSkill;
import kodlamaio.HRMS.entities.dtos.JobSeekerForAddSkillDto;

@Service
public class CvSkillManager implements CvSkillService{
	
	private CvSkillDao cvSkillDao;
	
	@Autowired
	public CvSkillManager(CvSkillDao cvSkillDao) {
		super();
		this.cvSkillDao = cvSkillDao;
	}

	@Override
	public Result range(List<JobSeekerForAddSkillDto> skills, Cv cv) {
		for(JobSeekerForAddSkillDto skill : skills) {
			
			if(!checkIfSkillExistsInDatabase(skill.getSkill().getSkillId()).isSuccess()) {
				return new ErrorResult();
			}
			CvSkill cvSkill = new CvSkill(cv,skill.getSkill(),skill.getSkillLevel());
			cvSkillDao.save(cvSkill);
		}
		return new SuccessResult();
	}
	
	
	private Result checkIfSkillExistsInDatabase(int skillId) {
		if(cvSkillDao.findById(skillId) == null) {
			return new ErrorResult();
		}
		return new SuccessResult();
	}
}
