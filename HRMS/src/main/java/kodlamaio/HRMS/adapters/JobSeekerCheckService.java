package kodlamaio.HRMS.adapters;

import kodlamaio.HRMS.entities.concretes.dtos.JobSeekerForRegisterDto;

public interface JobSeekerCheckService {
	
	boolean checkIfRealPerson(JobSeekerForRegisterDto jobSeeker);
	
}
