package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.SkillService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.ErrorDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.dataAccess.abstracts.SkillDao;
import kodlamaio.HRMS.entities.concretes.Skill;
import kodlamaio.HRMS.entities.dtos.SkillWithDetailsDto;

@Service
public class SkillManager implements SkillService{
	
	private SkillDao skillDao;
	
	@Autowired
	public SkillManager(SkillDao skillDao) {
		super();
		this.skillDao = skillDao;
	}

	@Override
	public DataResult<List<SkillWithDetailsDto>> getByCv_Id(int id) {
		return new SuccessDataResult<List<SkillWithDetailsDto>>(skillDao.findByCv_CvId(id));
	}

	@Override
	public DataResult<Skill> getById(int id) {
		Skill skill = skillDao.getOne(id);
		if(skill == null) {
			return new ErrorDataResult<Skill>();
		}
		return new SuccessDataResult<Skill>(skill);
	}

	

}
