package kodlamaio.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.HRMS.entities.concretes.JobPosition;

@Repository
public interface JobPositionDao extends JpaRepository<JobPosition, Integer>{
	
	JobPosition findByPositionName(String positionName);
	
	JobPosition findById(int id);
	
}
