package kodlamaio.HRMS.entities.concretes;


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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="cv_foreign_languages")
public class CvForeignLanguage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cv_foreign_language_id")
	private int cvForeignLanguageId;
	

	@ManyToOne
	@JoinColumn(name="cv_id")
	private Cv cv;
	
	@ManyToOne
	@JoinColumn(name="foreign_language_id")
	private ForeignLanguage foreignLanguage;
	
	@Column(name = "level")
	private int level;

	public CvForeignLanguage(Cv cv, ForeignLanguage foreignLanguage, int level) {
		super();
		this.cv = cv;
		this.foreignLanguage = foreignLanguage;
		this.level = level;
	}
	
	
	
}
