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

@Data
@Entity
@Table(name = "job_advertisements")
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "job_description")
	private String jobDescription;
	
	@Column(name = "max_salary")
	private double maxSalary;
	
	@Column(name = "min_salary")
	private double minSalary;
	
	@Column(name = "open_position_count")
	private int openPositionCount;
	
	@Column(name = "application_deadline")
	private Date applicationDeadline;
	
	@Column(name = "is_active")
	private boolean isActive;
	
	@Column(name = "create_date")
	private Date createDate;
	
	@Column(name="working_time")
	private int workingTime;
	
	@Column(name="working_type")
	private int workingType;
	
	@Column(name="approved")
	private boolean approved;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "city_id")
	private City city;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "job_position_id")
	private JobPosition jobPosition;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employer_id")
	private Employer employer;
	
	public JobAdvertisement(String jobDescription, double maxSalary, double minSalary, int openPositionCount,
			Date applicationDeadline,boolean isActive,City city, JobPosition jobPosition, Employer employer,int workingTime,int workingType,boolean approved) {
		super();
		this.jobDescription = jobDescription;
		this.maxSalary = maxSalary;
		this.minSalary = minSalary;
		this.openPositionCount = openPositionCount;
		this.applicationDeadline = applicationDeadline;
		this.city = city;
		this.jobPosition=jobPosition;
		this.employer=employer;
		this.isActive = isActive;
		this.createDate = new Date();
		this.workingTime = workingTime;
		this.workingType = workingType;
		this.approved = approved;
	}

}
