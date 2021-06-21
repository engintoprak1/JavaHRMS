package kodlamaio.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.HRMS.entities.concretes.SchoolDepartment;
import kodlamaio.HRMS.entities.dtos.SchoolDepartmentWithDetailsDto;

public interface SchoolDepartmentDao extends JpaRepository<SchoolDepartment, Integer>{
	
	@Query("Select new kodlamaio.HRMS.entities.dtos.SchoolDepartmentWithDetailsDto"
			+ "(sd.departmentName,js.schoolStartDate,js.graduationDate,sd.school.schoolName) From SchoolDepartment sd JOIN sd.jobSeekerSchoolDepartments js "
			+ "Where js.jobSeeker.userId=:userId Order By js.graduationDate DESC")
	List<SchoolDepartmentWithDetailsDto> findByJobSeekerSchoolDepartments_JobSeeker_userId(int userId);
	
}
