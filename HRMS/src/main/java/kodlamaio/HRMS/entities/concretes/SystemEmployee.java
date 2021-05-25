package kodlamaio.HRMS.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "system_employees")
@AllArgsConstructor
@NoArgsConstructor
public class SystemEmployee {
	
	@Id
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "role")
	private String role;
	
}
