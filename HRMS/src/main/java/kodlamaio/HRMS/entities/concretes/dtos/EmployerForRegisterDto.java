package kodlamaio.HRMS.entities.concretes.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerForRegisterDto {
	
	private String companyName;
	private String webSite;
	private String phoneNumber;
	private String email;
	private String password;
	private String passwordVerified;
	
}
