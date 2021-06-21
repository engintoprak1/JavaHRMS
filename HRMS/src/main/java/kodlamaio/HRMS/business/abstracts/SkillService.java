package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.entities.concretes.Skill;
import kodlamaio.HRMS.entities.dtos.SkillWithDetailsDto;

public interface SkillService {
	
	DataResult<List<SkillWithDetailsDto>> getByCv_Id(int id);
	
	DataResult<Skill> getById(int id);
	
}
