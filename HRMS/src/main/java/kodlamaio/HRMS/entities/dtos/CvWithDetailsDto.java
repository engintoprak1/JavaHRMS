package kodlamaio.HRMS.entities.dtos;

import java.util.List;

import kodlamaio.HRMS.entities.concretes.JobExperience;
import kodlamaio.HRMS.entities.concretes.JobSeeker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvWithDetailsDto {
	
	private int id;
    private String githubAddress;
    private String linkedinAddress;
    private String coverLetter;
    private String photo;
    private JobSeeker jobSeeker;
    
    private List<JobExperience> jobExperiences;
    private List<SchoolDepartmentWithDetailsDto> schoolDepartments;
    private List<ForeignLanguageWithDetailsDto> foreignLanguages;
    private List<SkillWithDetailsDto> skills;
    
	public CvWithDetailsDto(int id, String githubAddress, String linkedinAddress, String coverLetter, String photo,
			JobSeeker jobSeeker) {
		super();
		this.id = id;
		this.githubAddress = githubAddress;
		this.linkedinAddress = linkedinAddress;
		this.coverLetter = coverLetter;
		this.photo = photo;
		this.jobSeeker = jobSeeker;
	}
}
