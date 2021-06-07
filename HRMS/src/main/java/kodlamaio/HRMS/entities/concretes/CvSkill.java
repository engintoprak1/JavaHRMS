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
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="cv_skills")
public class CvSkill {
	
	@Id
	@Column(name="cv_skill_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cvSkillId;
	
	@ManyToOne
	@JoinColumn(name="cv_id")
	private Cv cv;
	
	@ManyToOne
	@JoinColumn(name = "skill_id")
	private Skill skill;
	
	@Column(name="skill_level")
	private int skillLevel;

	public CvSkill(Cv cv, Skill skill, int skillLevel) {
		super();
		this.cv = cv;
		this.skill = skill;
		this.skillLevel = skillLevel;
	}
	
}
