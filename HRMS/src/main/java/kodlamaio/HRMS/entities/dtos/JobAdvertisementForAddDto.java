package kodlamaio.HRMS.entities.dtos;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementForAddDto {
	
	@NotNull
	@Min(value = 1)
	private int jobPositionId;
	
	@NotNull
	@Min(value = 1)
	private int employerId;
	
	@NotNull
	@Min(value = 1)
	private int cityId;
	
	@NotNull
	@NotBlank
	@Size(max = 1000)
	private String jobDescription;
	
	@Min(value = 0)
	private Double minSalary;
	
	@Min(value = 0)
	private Double maxSalary;
	
	@Min(value = 0)
	private int openPositionCount;
	
	private Date applicationDeadline;
	private boolean isActive;
	private int workingTime;
	private int workingType;
	
}
