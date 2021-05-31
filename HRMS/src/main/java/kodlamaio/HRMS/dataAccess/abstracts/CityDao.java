package kodlamaio.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.HRMS.entities.concretes.City;

@Repository
public interface CityDao extends JpaRepository<City, Integer>{
	
	City findById(int id); 

}
