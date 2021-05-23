package kodlamaio.HRMS.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "job_seekers")
@Data
public class JobSeeker {
	
	@Id
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "nationality_id")
	private String nationalityId;
	
	@Column(name = "date_of_birth")
	private Date dateOfBirth;
	
	public JobSeeker() {}
	
	public JobSeeker(int userId, String firstName, String lastName, String nationalityId, Date dateOfBirth) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationalityId = nationalityId;
		this.dateOfBirth = dateOfBirth;
	}
	
}
