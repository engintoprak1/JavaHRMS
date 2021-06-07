package kodlamaio.HRMS.adapters;

import kodlamaio.HRMS.entities.dtos.JobSeekerForRegisterDto;

public interface JobSeekerCheckService {
	
	boolean checkIfRealPerson(JobSeekerForRegisterDto jobSeeker);
	
}
