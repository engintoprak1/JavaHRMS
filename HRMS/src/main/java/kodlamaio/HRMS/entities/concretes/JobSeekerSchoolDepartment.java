package kodlamaio.HRMS.entities.concretes;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	private int jobSeekerSchoolDepartmentId;
	
	@Column(name="start_date")
	private Date startDate;
	
	@Column(name="graduation_date")
	private Date graduationDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "job_seeker_id")
	private JobSeeker jobSeeker;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "school_department_id")
	private SchoolDepartment schoolDepartment;
}