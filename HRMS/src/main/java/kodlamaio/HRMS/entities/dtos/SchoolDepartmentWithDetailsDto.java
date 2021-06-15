package kodlamaio.HRMS.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolDepartmentWithDetailsDto {
	
	private String departmentName;
	
	private LocalDate schoolStartDate;
	
	private LocalDate graduationDate;
	
	private String schoolName;
	
}
