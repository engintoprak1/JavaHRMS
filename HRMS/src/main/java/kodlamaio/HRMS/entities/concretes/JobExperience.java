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
	
	@Column(name="start_date")
	private Date startDate;
	
	@Column(name="departure_date")
	private Date departureDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cv_id")
	private Cv cv;
	
}
