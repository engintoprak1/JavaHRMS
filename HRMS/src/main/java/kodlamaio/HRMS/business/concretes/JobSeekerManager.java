package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.adapters.JobSeekerCheckService;
import kodlamaio.HRMS.business.abstracts.JobSeekerService;
import kodlamaio.HRMS.business.abstracts.UserService;
import kodlamaio.HRMS.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.HRMS.entities.concretes.JobSeeker;
import kodlamaio.HRMS.entities.concretes.User;
import kodlamaio.HRMS.entities.concretes.dtos.JobSeekerForRegisterDto;
import kodlamaio.HRMS.core.utilities.results.*;

@Service
public class JobSeekerManager implements JobSeekerService{

	private JobSeekerDao jobSeekerDao;
	private UserService userService;
	private JobSeekerCheckService checkService;
	private JobSeekerService jobSeekerService;
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, UserService userService, JobSeekerCheckService checkService,JobSeekerService jobSeekerService) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.userService = userService;
		this.checkService = checkService;
		this.jobSeekerService = jobSeekerService;
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(),"İş arayanlar listelendi.");
	}

	@Override
	public Result register(JobSeekerForRegisterDto jobSeeker) {
		
		if(areAllFieldsFilled(jobSeeker) != null && checkService.checkIfRealPerson(jobSeeker) == false 
				&& isEmailExist(jobSeeker) != null && isIdentityExist(jobSeeker) != null) {
			return new ErrorResult("Kayıt gerçekleştirilemedi.");
		}else {
			User userToRegister = new User(jobSeeker.getEmail(),jobSeeker.getPassword(),false);
			
			userService.register(userToRegister);
			
			JobSeeker jobSeekerToRegister = new JobSeeker(userToRegister.getId(),jobSeeker.getFirstName(),jobSeeker.
					getLastName(),jobSeeker.getNationalityId(),jobSeeker.getDateOfBirth());
			
			jobSeekerDao.save(jobSeekerToRegister);
			
			return new SuccessResult("İş arayan kaydı başarılı.");
		}
		
	}
	
	
	//iş kuralları
	
	
/* bütün alanların doldurulması zorunludur kuralı.
   .equals("") yapmamın sebebi = "" gibi boş bir string yolladığımızda null olmaz ve 
   veri girişi gerçekleşir bu sebeple boş string kontrolü de yapmamız gerekmektedir. */
	
	public Result areAllFieldsFilled(JobSeekerForRegisterDto jobSeeker) {
		
		if(jobSeeker.getFirstName() == null || jobSeeker.getFirstName().equals("")
				|| jobSeeker.getLastName() == null || jobSeeker.getLastName().equals("") 
				|| jobSeeker.getEmail() == null || jobSeeker.getEmail().equals("") 
				|| jobSeeker.getNationalityId() == null || jobSeeker.getNationalityId().equals("") 
				|| jobSeeker.getPassword() == null || jobSeeker.getPassword().equals("")
				|| jobSeeker.getVerifyPassword() == null || jobSeeker.getVerifyPassword().equals("")
				|| jobSeeker.getDateOfBirth() == null) 
			
				{
					return new ErrorResult("Lütfen bilgileri eksiksiz doldurunuz.");
				}else {
					return null;
				}
	}
	
	@Override
	public DataResult<JobSeeker> getByNationalityId(String userId) {
		
		JobSeeker jobSeeker = jobSeekerDao.findByNationalityId(userId);
		
		return new SuccessDataResult<JobSeeker>(jobSeeker);
	}
	
	
	public Result isEmailExist(JobSeekerForRegisterDto jobSeeker) {
		
		if(userService.getByEmail(jobSeeker.getEmail()) != null) {
			return new ErrorResult("Bu e-posta zaten kullanılıyor.");
		}else {
			return null;
		}
		
	}
	
	
	public Result isIdentityExist(JobSeekerForRegisterDto jobSeeker) {
		
		if(jobSeekerService.getByNationalityId(jobSeeker.getNationalityId()) != null) {
			return new ErrorResult("Bu kimlik numarası kullanılıyor.");
		}else {
			return null;
		}
		
	}
	
	
	

	
	

	

}
