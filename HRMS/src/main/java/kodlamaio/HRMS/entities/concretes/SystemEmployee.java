package kodlamaio.HRMS.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "system_employees")
@Data
public class SystemEmployee {
	
	@Id
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "role")
	private String role;
	
	@Column(name = "company_verified")
	private boolean companyVerified;
	
	public SystemEmployee() {}
	
	public SystemEmployee(int userId, String role, boolean companyVerified) {
		super();
		this.userId = userId;
		this.role = role;
		this.companyVerified = companyVerified;
	}
	
}
