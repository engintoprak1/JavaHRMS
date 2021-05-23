package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.entities.concretes.JobPosition;

public interface JobPositionService {
	List<JobPosition> getAll();
}
