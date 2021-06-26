package kodlamaio.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HRMS.entities.concretes.JobAdvertisement;


public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{
	
	List<JobAdvertisement> findByIsActiveTrue();
	
	List<JobAdvertisement> findByIsActiveTrueOrderByApplicationDeadline();
	
	List<JobAdvertisement> findByIsActiveTrueAndEmployer_UserId(int userId);
	
	List<JobAdvertisement> findByApprovedTrueAndIsActiveTrue();
	
	JobAdvertisement findByIdAndEmployer_UserId(int id, int userId);
	
	

}
