package kodlamaio.HRMS.entities.concretes.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementForAddDto {
	
	private int jobPositionId;
	private int employerId;
	private int cityId;
	private String jobDescription;
	private Double minSalary;
	private Double maxSalary;
	private int openPositionCount;
	private Date applicationDeadline;
	private boolean isActive;
}
