package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.entities.concretes.JobSeeker;

public interface JobSeekerService {
	List<JobSeeker> getAll();	
}
