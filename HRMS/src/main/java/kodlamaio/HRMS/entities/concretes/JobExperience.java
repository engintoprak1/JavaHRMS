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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="job_experiences")
@NoArgsConstructor
@AllArgsConstructor
public class JobExperience {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="workplace_name")
	private String workplaceName;
	
	@Column(name="position")
	private String position;
	
	@Column(name="job_start_date")
	private LocalDate jobStartDate;
	
	@Column(name="departure_date")
	private LocalDate departureDate;
	
	@ManyToOne()
	@JoinColumn(name = "cv_id")
	@JsonIgnore
	private Cv cv;
	
	
	public JobExperience(String workplaceName, String position, LocalDate jobStartDate, LocalDate departureDate, Cv cv) {
		super();
		this.workplaceName = workplaceName;
		this.position = position;
		this.jobStartDate = jobStartDate;
		this.departureDate = departureDate;
		this.cv = cv;
	}
}
