package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.entities.concretes.SystemEmployee;

public interface SystemEmployeeService {
	List<SystemEmployee> getAll();
}
