package kodlamaio.HRMS.entities.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolDepartmentWithDetailsDto {
	
	private String departmentName;
	
	private Date schoolStartDate;
	
	private Date graduationDate;
	
	private String schoolName;
	
}
