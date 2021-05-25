package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.UserService;
import kodlamaio.HRMS.core.utilities.helpers.email.EmailService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.ErrorResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.UserDao;
import kodlamaio.HRMS.entities.concretes.User;


@Service
public class UserManager implements UserService{
	
	private UserDao userDao;
	private EmailService emailService;
	
	@Autowired
	public UserManager(UserDao userDao, EmailService emailService) {
		super();
		this.userDao = userDao;
		this.emailService = emailService;
	}

	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(this.userDao.findAll(),"Listelendi");
	}

	@Override
	public Result add(User user) {
		
			this.userDao.save(user);
			this.emailService.send(user.getEmail(), "HOŞGELDİNİZ. " 
			+ "Linke tıklayarak üyeliğinizi doğrulayabilirsiniz. \n "
			+ "www.localhost:8080/api/users/verify?email=" + user.getEmail() + "&verifycode=" + user.getEmailVerifyCode());
		
		return new SuccessResult("Kayıt Başarılı.");
	}
	

	@Override
	public DataResult<User> getByEmail(String email) {
		
		User user = userDao.findByEmail(email);
		
		return new SuccessDataResult<User>(user);
		
	}

	@Override
	public Result verifyUser(String email, String verificationCode) {
		User user = userDao.findByEmailAndEmailVerifyCode(email, verificationCode);
		
		if (user == null) {
			return new ErrorResult("Doğrulama başarısız lütfen bilgileri kontrol ediniz.");
		}
		
		user.setEmailVerified(true);
		userDao.save(user);
		return new SuccessResult("Kullanıcı e-postası başarıyla doğrulandı.");
	}
	

}
