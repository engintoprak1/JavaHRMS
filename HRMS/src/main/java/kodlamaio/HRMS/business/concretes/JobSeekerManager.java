package kodlamaio.HRMS.business.concretes;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import kodlamaio.HRMS.business.abstracts.JobSeekerService;
import kodlamaio.HRMS.business.abstracts.UserService;
import kodlamaio.HRMS.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.HRMS.entities.concretes.JobSeeker;
import kodlamaio.HRMS.entities.dtos.JobSeekerForRegisterDto;
import kodlamaio.HRMS.core.entities.User;
import kodlamaio.HRMS.core.utilities.results.*;

@Service
public class JobSeekerManager implements JobSeekerService {

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
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(), "İş arayanlar listelendi.");
	}

	@Override
	public Result registerForJobSeeker(JobSeekerForRegisterDto jobSeekerForRegisterDto) {

		if (isEmailExist(jobSeekerForRegisterDto).isSuccess() == false) {
			return new ErrorResult("Bu e-posta adresi kullanılmaktadır.");
		}

		if (isIdentityExist(jobSeekerForRegisterDto).isSuccess() == false) {

			return new ErrorResult("Bu kimlik numarası ile kullanıcı mevcut");

		}
		if (arePasswordsMatching(jobSeekerForRegisterDto).isSuccess() == false) {

			return new ErrorResult("Şifreler uyuşmuyor.");

		}
		if (!this
				.mernisValidate(jobSeekerForRegisterDto.getNationalityId(), jobSeekerForRegisterDto.getFirstName(),
						jobSeekerForRegisterDto.getLastName(), jobSeekerForRegisterDto.getDateOfBirth().getYear())
				.isSuccess()) {

			return new ErrorResult("Kimlik doğrulaması başarısız.");

		}

		User userToRegister = new User(jobSeekerForRegisterDto.getEmail(), jobSeekerForRegisterDto.getPassword(), false,
				UUID.randomUUID().toString());

		userService.add(userToRegister);

		JobSeeker jobSeekerToRegister = new JobSeeker(userToRegister.getId(), jobSeekerForRegisterDto.getFirstName(),
				jobSeekerForRegisterDto.getLastName(), jobSeekerForRegisterDto.getNationalityId(),
				jobSeekerForRegisterDto.getDateOfBirth());

		jobSeekerDao.save(jobSeekerToRegister);

		return new SuccessResult("İş arayan kaydı başarılı. Lütfen e-posta adresinize gelen doğrulama kodunu giriniz.");
	}

	

	private Result mernisValidate(String tckNo, String firstName, String lastName, int yearOfDate) {
		return new SuccessResult();
	}

	private Result isEmailExist(JobSeekerForRegisterDto jobSeeker) {

		if (userService.getByEmail(jobSeeker.getEmail()).getData() != null) {
			return new ErrorResult();
		} else {
			return new SuccessResult();
		}
	}

	private Result arePasswordsMatching(JobSeekerForRegisterDto jobSeeker) {

		if (!jobSeeker.getPassword().equals(jobSeeker.getVerifyPassword())) {
			return new ErrorResult();
		} else {
			return new SuccessResult();
		}

	}

	private Result isIdentityExist(JobSeekerForRegisterDto jobSeeker) {

		if (jobSeekerDao.findByNationalityId(jobSeeker.getNationalityId()) != null) {
			return new ErrorResult();
		} else {
			return new SuccessResult();
		}

	}

	@Override
	public DataResult<JobSeeker> getById(int id) {
		JobSeeker jobSeeker = jobSeekerDao.findById(id);
		if(jobSeeker == null) {
			return new ErrorDataResult<JobSeeker>();
		}
		return new SuccessDataResult<JobSeeker>(jobSeeker);
	}

}
