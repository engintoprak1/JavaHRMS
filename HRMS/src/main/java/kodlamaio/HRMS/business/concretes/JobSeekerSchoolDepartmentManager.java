package kodlamaio.HRMS.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.JobSeekerSchoolDepartmentService;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.JobSeekerSchoolDeparmentDao;
import kodlamaio.HRMS.entities.concretes.JobSeekerSchoolDepartment;

@Service
public class JobSeekerSchoolDepartmentManager implements JobSeekerSchoolDepartmentService{
	
	private JobSeekerSchoolDeparmentDao jobSeekerSchoolDeparmentDao;
	
	@Autowired
	public JobSeekerSchoolDepartmentManager(JobSeekerSchoolDeparmentDao jobSeekerSchoolDeparmentDao) {
		super();
		this.jobSeekerSchoolDeparmentDao = jobSeekerSchoolDeparmentDao;
	}

	@Override
	public Result add(JobSeekerSchoolDepartment jobSeekerSchoolDepartment) {
		this.jobSeekerSchoolDeparmentDao.save(jobSeekerSchoolDepartment);
		return new SuccessResult();
	}

}
