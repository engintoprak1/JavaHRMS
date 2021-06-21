package kodlamaio.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HRMS.entities.concretes.JobSeekerSchoolDepartment;


public interface JobSeekerSchoolDeparmentDao extends JpaRepository<JobSeekerSchoolDepartment, Integer>{

}
