package kodlamaio.HRMS.business.concretes;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.EmployerService;
import kodlamaio.HRMS.business.abstracts.UserService;
import kodlamaio.HRMS.core.entities.User;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.ErrorDataResult;
import kodlamaio.HRMS.core.utilities.results.ErrorResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.EmployerDao;
import kodlamaio.HRMS.entities.concretes.Employer;
import kodlamaio.HRMS.entities.concretes.dtos.EmployerForRegisterDto;

@Service
public class EmployerManager implements EmployerService{
	
	private EmployerDao employerDao;
	private UserService userService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao,UserService userService) {
		super();
		this.employerDao = employerDao;
		this.userService = userService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"Listelendi.");
	}

	@Override
	public Result register(EmployerForRegisterDto employer) {
		
		if(isEmailExists(employer).isSuccess() == false) {
			return new ErrorResult("Bu e-posta adresi kullanılmaktadır.");
		}if(arePasswordsMatching(employer).isSuccess() == false) {
			return new ErrorResult("Şifreler uyuşmuyor.");
		}if(isEmailandWebsiteDomainSame(employer).isSuccess() == false){
			return new ErrorResult("E posta adresinizin domaini ile web siteniz aynı olmalıdır.");
		}
		
		User userToRegister = new User(employer.getEmail(),employer.getPassword(),false, UUID.randomUUID().toString());
		
		userService.add(userToRegister);
		
		Employer employerToRegister = new Employer(userToRegister.getId(),employer.getCompanyName(),employer.getWebSite(),employer.getPhoneNumber(),false);
		
		employerDao.save(employerToRegister);
		
		return new SuccessResult("İş veren kaydı başarılı. E-posta adresine gönderilen link ile hesabınızı doğrulayabilirsiniz.");
		
	}
	
	
	private Result isEmailandWebsiteDomainSame(EmployerForRegisterDto employer) {
		String email = employer.getEmail();
		String[] emailSplit = email.split("@");
		if(!emailSplit[1].equals(employer.getWebSite())) {
			return new ErrorResult();
		}else {
			return new SuccessResult();
		}
		
	}
	
	private Result isEmailExists(EmployerForRegisterDto employer) {
		
		if(userService.getByEmail(employer.getEmail()).getData() != null) {
			return new ErrorResult();
		}
		return new SuccessResult();
	}
	
	private Result arePasswordsMatching(EmployerForRegisterDto employer) {
		
		if(!employer.getPassword().equals(employer.getVerifyPassword())) {
			return new ErrorResult();
		}
		return new SuccessResult();
	}

	@Override
	public DataResult<Employer> getById(int id) {
		Employer employer = employerDao.findById(id);
		
		if(employer == null) {
			return new ErrorDataResult<Employer>();
		}

		
		return new SuccessDataResult<Employer>(employer);
	}
	
	
	
	
}
