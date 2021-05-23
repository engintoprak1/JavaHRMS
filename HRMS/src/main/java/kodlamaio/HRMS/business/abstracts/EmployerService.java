package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.entities.concretes.Employer;

public interface EmployerService {
	List<Employer> getAll();
}
