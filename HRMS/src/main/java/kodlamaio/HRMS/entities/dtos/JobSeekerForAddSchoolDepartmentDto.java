package kodlamaio.HRMS.entities.dtos;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import kodlamaio.HRMS.entities.concretes.JobSeeker;
import kodlamaio.HRMS.entities.concretes.SchoolDepartment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerForAddSchoolDepartmentDto {
	
	@NotNull
	private SchoolDepartment schoolDepartment;
	
	@NotNull
	private JobSeeker jobSeeker;
	
	@NotNull
	private LocalDate schoolStartDate;
	
	private LocalDate graduationDate;
}
