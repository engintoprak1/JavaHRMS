package kodlamaio.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.HRMS.entities.concretes.Cv;
import kodlamaio.HRMS.entities.dtos.CvWithDetailsDto;


public interface CvDao extends JpaRepository<Cv, Integer>{
	
	@Query("Select new kodlamaio.HRMS.entities.dtos.CvWithDetailsDto(c.id,c.githubAddress,c.linkedinAddress,c.coverLetter,c.createDate,c.photo,j) From Cv c JOIN c.jobSeeker j Where c.id=:id")
	CvWithDetailsDto findCvWithDetailsById(int id);
	
}
