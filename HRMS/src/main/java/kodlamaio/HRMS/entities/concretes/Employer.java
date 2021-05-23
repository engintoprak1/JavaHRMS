package kodlamaio.HRMS.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="employers")
@Data
public class Employer {
	
	@Id
	@Column(name="user_id")
	private int userId;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="web_site")
	private String webSite;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	public Employer() {}
	
	public Employer(int userId, String companyName, String webSite, String phoneNumber) {
		super();
		this.userId = userId;
		this.companyName = companyName;
		this.webSite = webSite;
		this.phoneNumber = phoneNumber;
	}
	
}
