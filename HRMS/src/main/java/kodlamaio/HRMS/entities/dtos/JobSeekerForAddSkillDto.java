package kodlamaio.HRMS.entities.dtos;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import kodlamaio.HRMS.entities.concretes.Skill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerForAddSkillDto {
	
	
	@NotNull
	private Skill skill;
	
	@NotNull
	@Min(1)
	@Max(3)
	private int skillLevel;
}
