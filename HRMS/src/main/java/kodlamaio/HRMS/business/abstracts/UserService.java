package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.User;

public interface UserService {
	
	DataResult<List<User>> getAll();
	
	Result add(User user);
	
	DataResult<User> getByEmail(String email);
	
	Result verifyUser(String email, String verificationCode);
	
	
}
