package kodlamaio.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.HRMS.entities.concretes.ForeignLanguage;
import kodlamaio.HRMS.entities.dtos.ForeignLanguageWithDetailsDto;


public interface ForeignLanguageDao extends JpaRepository<ForeignLanguage, Integer>{
	
	ForeignLanguage findById(int id);
	
	@Query("Select new kodlamaio.HRMS.entities.dtos.ForeignLanguageWithDetailsDto(fl.language,cfl.level)"
			+ "From ForeignLanguage fl JOIN fl.cvForeignLanguages cfl Where cfl.cv.id = :id")
	List<ForeignLanguageWithDetailsDto> findByCvId_cvId(int id);
	
}
