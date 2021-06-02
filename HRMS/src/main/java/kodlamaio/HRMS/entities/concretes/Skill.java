package kodlamaio.HRMS.entities.concretes;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "skillls")
@AllArgsConstructor
@NoArgsConstructor
public class Skill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@ManyToMany()
	@JoinTable(
			 name = "cv_skills", 
			 joinColumns = @JoinColumn(name = "skill_id"), 
			 inverseJoinColumns = @JoinColumn(name = "cv_id"))
	 private Set<Cv> cvs;
	
}
