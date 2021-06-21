package kodlamaio.HRMS.adapters;

import java.rmi.RemoteException;
import java.util.Locale;

import org.springframework.stereotype.Service;

import kodlamaio.HRMS.entities.dtos.JobSeekerForRegisterDto;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisServiceAdapter implements JobSeekerCheckService{

	@Override
	public boolean checkIfRealPerson(JobSeekerForRegisterDto jobSeeker) {
		System.out.println("x");
		KPSPublicSoapProxy client = new KPSPublicSoapProxy();
		
		var result = true;
		
		try {
			result = client.TCKimlikNoDogrula(Long.parseLong(jobSeeker.getNationalityId()), 
					jobSeeker.getFirstName().toUpperCase(new Locale("tr")), 
					jobSeeker.getLastName().toUpperCase(new Locale("tr")),jobSeeker.getDateOfBirth().getYear());
			} catch (NumberFormatException e) {
				System.out.println("Lütfen kimlik numaranızı sayı formatında giriniz.");
			} catch (RemoteException e) {
				e.printStackTrace();
		}
		
		if(result) {
			System.out.println("Kimlik doğrulaması başarılı.");
		}else {
			System.out.println("Kimlik doğrulaması başarısız.");
			result = false;
		}
		
		return result;
		
	}
}
