package kodlamaio.HRMS.core.utilities.helpers.email;


import kodlamaio.HRMS.core.utilities.results.Result;

public interface EmailService {
	
	Result send(String to, String message);
	
}
