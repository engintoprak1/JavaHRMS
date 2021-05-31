package kodlamaio.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.HRMS.entities.concretes.SystemEmployee;

@Repository
public interface SystemEmployeeDao extends JpaRepository<SystemEmployee, Integer>{

}
