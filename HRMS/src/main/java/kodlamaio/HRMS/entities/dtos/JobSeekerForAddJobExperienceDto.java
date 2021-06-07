package kodlamaio.HRMS.entities.dtos;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerForAddJobExperienceDto {


	@NotNull
	@NotBlank
	private String workplaceName;

	@NotNull
	@NotBlank
	private String position;

	@NotNull
	private Date jobStartDate;

	private Date departureDate;

}
