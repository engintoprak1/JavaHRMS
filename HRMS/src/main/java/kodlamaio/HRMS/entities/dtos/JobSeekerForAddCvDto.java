package kodlamaio.HRMS.entities.dtos;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerForAddCvDto {
	
	@NotNull
	private MultipartFile photo;
	
	@NotNull
	@NotBlank
	private String githubAdress;
	
	@NotNull
	@NotBlank
	private String linkedinAdress;
	
	@NotNull
	@NotBlank
	private String coverLetter;
	
	private int jobSeekerId;
	
	@Valid
	private List<JobSeekerForAddJobExperienceDto> jobExperiences;
	
	@Valid
	private List<JobSeekerForAddForeignLanguageDto> foreignLanguages;
	
	@Valid
	private List<JobSeekerForAddSkillDto> skills;

}
