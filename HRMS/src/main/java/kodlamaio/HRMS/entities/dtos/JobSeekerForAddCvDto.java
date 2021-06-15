package kodlamaio.HRMS.entities.dtos;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerForAddCvDto {
	
	private String githubAdress;
	
	private String linkedinAdress;

	private String coverLetter;
	
	private MultipartFile photo;
	
	private int jobSeekerId;
	
	@Valid
	private List<JobSeekerForAddJobExperienceDto> jobExperiences;
	
	@Valid
	private List<JobSeekerForAddForeignLanguageDto> foreignLanguages;
	
	@Valid
	private List<JobSeekerForAddSkillDto> skills;

}
