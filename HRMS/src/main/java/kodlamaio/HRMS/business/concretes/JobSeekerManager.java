package kodlamaio.HRMS.business.concretes;

import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, UserService userService) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.userService = userService;
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(),"İş arayanlar listelendi.");
	}

	@Override
	public Result register(JobSeekerForRegisterDto jobSeeker) {
		
		if(areAllFieldsFilled(jobSeeker).isSuccess() == false) {
			
			return new ErrorResult("Tüm alanlar doldurulmalıdır.");
			
		}if(isEmailExist(jobSeeker).isSuccess() == false) {
			
			return new ErrorResult("Bu e-posta adresi kullanılmaktadır.");
			
		}if(!isEmailFormat(jobSeeker.getEmail())) {
			return new ErrorResult("E-postanız e-posta formatında olmalıdır.");
		}
		if(isIdentityExist(jobSeeker).isSuccess() == false) {
			
			return new ErrorResult("Bu kimlik numarası ile kullanıcı mevcut");
			
		}if(arePasswordsMatching(jobSeeker).isSuccess() == false) {
			
			return new ErrorResult("Şifreler uyuşmuyor.");
			
		}if(!this.mernisValidate(jobSeeker.getNationalityId(), jobSeeker.getFirstName(), jobSeeker.getLastName(), jobSeeker.getDateOfBirth().getYear()).isSuccess()){
			
			return new ErrorResult("Kimlik doğrulaması başarısız.");
			
		}
		
		
		
			User userToRegister = new User(jobSeeker.getEmail(),jobSeeker.getPassword(),false, UUID.randomUUID().toString());
			
			userService.add(userToRegister);
			
			JobSeeker jobSeekerToRegister = new JobSeeker(userToRegister.getId(),jobSeeker.getFirstName(),jobSeeker.
					getLastName(),jobSeeker.getNationalityId(),jobSeeker.getDateOfBirth());
			
			jobSeekerDao.save(jobSeekerToRegister);
			
			return new SuccessResult("İş arayan kaydı başarılı. Lütfen e-posta adresinize gelen doğrulama kodunu giriniz.");
	}
		
	
/* bütün alanların doldurulması zorunludur kuralı.
   .equals("") yapmamın sebebi = "" gibi boş bir string yolladığımızda null olmaz ve 
   veri girişi gerçekleşir bu sebeple boş string kontrolü de yapmamız gerekmektedir. */
	
// Tüm alanlar zorunludur. Kullanıcı bilgilendirilir.
	
	public Result areAllFieldsFilled(JobSeekerForRegisterDto jobSeeker) {
		
		if(jobSeeker.getFirstName() == null || jobSeeker.getFirstName().equals("")
				|| jobSeeker.getLastName() == null || jobSeeker.getLastName().equals("") 
				|| jobSeeker.getEmail() == null || jobSeeker.getEmail().equals("") 
				|| jobSeeker.getNationalityId() == null || jobSeeker.getNationalityId().equals("") 
				|| jobSeeker.getPassword() == null || jobSeeker.getPassword().equals("")
				|| jobSeeker.getVerifyPassword() == null || jobSeeker.getVerifyPassword().equals("")
				|| jobSeeker.getDateOfBirth() == null) 
			
				{
					return new ErrorResult();
				}else {
					return new SuccessResult();
				}
	}
	
	private Result mernisValidate(String tckNo,String firstName, String lastName, int yearOfDate) {
		return new SuccessResult();
	}
	
	
	private Result isEmailExist(JobSeekerForRegisterDto jobSeeker) {
		
		
		if(userService.getByEmail(jobSeeker.getEmail()).getData() != null) {
			return new ErrorResult();
		}else {
			return new SuccessResult();
		}
	}
	
	private Result arePasswordsMatching(JobSeekerForRegisterDto jobSeeker) {
		
		if(!jobSeeker.getPassword().equals(jobSeeker.getVerifyPassword())) {
			return new ErrorResult();
		}else {
			return new SuccessResult();
		}
		
	}
	
	private Result isIdentityExist(JobSeekerForRegisterDto jobSeeker) {
		
		if(jobSeekerDao.findByNationalityId(jobSeeker.getNationalityId()) != null) {
			return new ErrorResult();
		}else {
			return new SuccessResult();
		}
		
	}
	
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	
	private boolean isEmailFormat(String email) {
		return VALID_EMAIL_ADDRESS_REGEX.matcher(email).find();
	}
	
	
	
	

}
