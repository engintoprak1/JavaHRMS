package kodlamaio.HRMS.entities.concretes;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@Column(name="github_address")
	private String githubAddress;
	
	@Column(name="linkedin_address")
	private String linkedinAddress;
	
	@Column(name="cover_letter")
	private String coverLetter;
	
	@Column(name = "create_date")
	private Date createDate;
	
	@Column(name="photo")
	private String photo;
	
	@ManyToOne()
	@JoinColumn(name = "job_seeker_id")
	@JsonIgnore
	private JobSeeker jobSeeker;
	
	@OneToMany(mappedBy = "cv")
	@JsonIgnore
	private List<JobExperience> jobExperiences;
	
	@OneToMany(mappedBy = "cv")
	@JsonIgnore
	private List<CvForeignLanguage> cvForeignLanguages;
	
	@OneToMany(mappedBy = "cv")
	@JsonIgnore
	private List<CvSkill> cvSkills;
	
	public Cv(String githubAddress, String linkedinAddress, String coverLetter,String photo, JobSeeker jobSeeker) {
		super();
		this.githubAddress = githubAddress;
		this.linkedinAddress = linkedinAddress;
		this.coverLetter = coverLetter;
		this.createDate = new Date();
		this.photo = photo;
		this.jobSeeker = jobSeeker;
		
	}
	
}
