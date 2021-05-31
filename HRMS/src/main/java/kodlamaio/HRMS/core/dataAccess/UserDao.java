package kodlamaio.HRMS.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.HRMS.core.entities.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer>{
	
	User findByEmail(String email);
	
	User findByEmailAndEmailVerifyCode(String email, String emailVerifyCode);
}
