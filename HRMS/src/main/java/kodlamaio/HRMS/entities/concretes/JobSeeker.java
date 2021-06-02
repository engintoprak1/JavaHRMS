package kodlamaio.HRMS.entities.concretes;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "job_seekers")
@AllArgsConstructor
@NoArgsConstructor
public class JobSeeker {
	
	@Id
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "nationality_id",unique = true)
	private String nationalityId;
	
	@Column(name = "date_of_birth")
	private Date dateOfBirth;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cv_id",referencedColumnName = "id")
	private Cv cv;
	
	@OneToMany(mappedBy = "jobSeeker")
	private List<JobSeekerSchoolDepartment> jobSeekerSchoolDepartments;
	
	
	public JobSeeker(int userId,String firstName, String lastName, String nationalityId, Date dateOfBirth) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationalityId = nationalityId;
		this.dateOfBirth = dateOfBirth;
	}
	
	
	

}
