package kodlamaio.HRMS.entities.dtos;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import kodlamaio.HRMS.entities.concretes.ForeignLanguage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerForAddForeignLanguageDto {
	
	
	@NotNull
	private ForeignLanguage foreignLanguage;
	
	@NotNull
	@Min(1)
	@Max(5)
	private int level;

}
