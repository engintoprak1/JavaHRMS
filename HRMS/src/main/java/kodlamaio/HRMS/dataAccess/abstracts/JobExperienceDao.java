package kodlamaio.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HRMS.entities.concretes.JobExperience;


public interface JobExperienceDao extends JpaRepository<JobExperience, Integer>{
	
	List<JobExperience> findByCv_idOrderByDepartureDateDesc(int id);
	
}
