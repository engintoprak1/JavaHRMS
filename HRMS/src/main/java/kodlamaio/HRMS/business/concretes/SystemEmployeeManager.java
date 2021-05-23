package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.SystemEmployeeService;
import kodlamaio.HRMS.dataAccess.abstracts.SystemEmployeeDao;
import kodlamaio.HRMS.entities.concretes.SystemEmployee;

@Service
public class SystemEmployeeManager implements SystemEmployeeService{
	
	private SystemEmployeeDao employeeDao;

	@Autowired
	public SystemEmployeeManager(SystemEmployeeDao employeeDao) {
		super();
		this.employeeDao = employeeDao;
	}

	@Override
	public List<SystemEmployee> getAll() {
		return this.employeeDao.findAll();
	}

}
