package kodlamaio.HRMS.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="foreign_languages")
@AllArgsConstructor
@NoArgsConstructor
public class ForeignLanguage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="language")
	private String language;
	
	@Column(name="level")
	@Min(value = 1)
	@Max(value = 5)
	private int level;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cv_id")
	private Cv cv;
	
}
