package kodlamaio.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.HRMS.entities.concretes.Skill;
import kodlamaio.HRMS.entities.dtos.SkillWithDetailsDto;


public interface SkillDao extends JpaRepository<Skill, Integer>{
	
	@Query("Select new kodlamaio.HRMS.entities.dtos.SkillWithDetailsDto(s.skillName,cs.skillLevel) From Skill s JOIN s.cvSkills cs Where cs.cv.id=:id")
	List<SkillWithDetailsDto> findByCv_CvId(int id); 
	
}
