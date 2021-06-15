package kodlamaio.HRMS.entities.concretes;

import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="job_seeker_school_departments")
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerSchoolDepartment{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="job_seeker_school_department_id")
	private int id;
	
	@Column(name="school_start_date")
	private LocalDate schoolStartDate;
	
	@Column(name="graduation_date")
	private LocalDate graduationDate;
	
	@ManyToOne()
	@JoinColumn(name = "job_seeker_id")
	private JobSeeker jobSeeker;
	
	@ManyToOne()
	@JoinColumn(name = "school_department_id")
	private SchoolDepartment schoolDepartment;

	public JobSeekerSchoolDepartment(JobSeeker jobSeeker,SchoolDepartment schoolDepartment, LocalDate schoolStartDate, LocalDate graduationDate){
		super();
		this.schoolStartDate = schoolStartDate;
		this.graduationDate = graduationDate;
		this.jobSeeker = jobSeeker;
		this.schoolDepartment = schoolDepartment;
	}
	
}
