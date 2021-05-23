package kodlamaio.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HRMS.entities.concretes.SystemEmployee;

public interface SystemEmployeeDao extends JpaRepository<SystemEmployee, Integer>{

}
