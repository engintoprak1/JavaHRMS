package kodlamaio.HRMS.core.utilities.helpers.email;

import org.springframework.stereotype.Service;

import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;

@Service
public class EmailManager implements EmailService{

	@Override
	public Result send(String to, String message) {
		return new SuccessResult("Doğrulama kodu gönderildi.");
	}

}
