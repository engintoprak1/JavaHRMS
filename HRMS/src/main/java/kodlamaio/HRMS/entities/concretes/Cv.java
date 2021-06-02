package kodlamaio.HRMS.entities.concretes;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="cvs")
@AllArgsConstructor
@NoArgsConstructor
public class Cv {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="photo")
	private String photo;
	
	@Column(name="github_adress")
	private String githubAddress;
	
	@Column(name="linkedin_address")
	private String linkedinAddress;
	
	@Column(name="cover_letter")
	private String coverLetter;
	
	@OneToOne(mappedBy = "cv")
	private JobSeeker jobSeeker;
	
	@OneToMany(mappedBy = "cv",fetch = FetchType.LAZY)
	private List<JobExperience> jobExperiences;
	
	@OneToMany(mappedBy = "cv",fetch = FetchType.LAZY)
	private List<ForeignLanguage> foreignLanguages;
	
	 @ManyToMany()
	 @JoinTable(
			   name = "cv_skills", 
			   joinColumns = @JoinColumn(name = "cv_id"), 
			   inverseJoinColumns = @JoinColumn(name = "skill_id"))
	 private Set<Cv> resumes;
	
}
