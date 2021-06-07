package kodlamaio.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HRMS.entities.concretes.CvSkill;

public interface CvSkillDao extends JpaRepository<CvSkill, Integer>{

}
