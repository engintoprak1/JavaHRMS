package kodlamaio.HRMS.entities.concretes.dtos;

import java.util.Date;

import javax.persistence.Column;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerForAddCvDto {
	
	@NotNull
	@Min(value = 1)
	private int schoolId;
	
	
	@NotNull
	@NotBlank
	private Date startDate;
	
	private Date graduationDate;
	
}
