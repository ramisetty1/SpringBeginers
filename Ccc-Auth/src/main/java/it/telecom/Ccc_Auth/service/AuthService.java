package it.telecom.Ccc_Auth.service;




import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.telecom.Ccc_Auth.entity.User;
import it.telecom.Ccc_Auth.pojo.LoginApiData;
import it.telecom.Ccc_Auth.pojo.ProfileUpdateApiData;
import it.telecom.Ccc_Auth.pojo.SignUpApiData;
import it.telecom.Ccc_Auth.repo.UserRepository;

@Service
public class AuthService {
	
	@Autowired
	public UserRepository userRepository;
	
	public User signupService(SignUpApiData signUpApiData) {
		
		

		User user = new User();
		
		user.setName(signUpApiData.getName());
		user.setEmail(signUpApiData.getEmail());
		user.setPassword(signUpApiData.getPassword());
		user.setMobileNumber(signUpApiData.getMobileNumber());
		User dbresponse =	userRepository.save(user);
		
		return dbresponse;
	
	}
	
	
	public Object profileUpdateService(ProfileUpdateApiData profileUpdateApiData) {
		
		Optional<User> dbresponse =	userRepository.findById(profileUpdateApiData.getId());
		// where id = profileUpdateApiData.getId()
		
		if (dbresponse.isEmpty()==true) {
			
			return "user not found";
		}else {
			
			User user = dbresponse.get();
			user.setPassword(profileUpdateApiData.getPassword());
			
			User dbUser =	userRepository.save(user);
			return dbUser;
					
		}
		
	}
	
	
	public Object getDetails(int id) {
		
	Optional<User> dbData=	userRepository.findById(id);
	
	if (dbData.isPresent()){
		
		return dbData.get();
	}else {
		return "user not found";
	}

		
	}
	
	public Object loginQuery(LoginApiData loginApiData) {
		
		Optional<User> dbUser =userRepository.dbLoginWithQuery(loginApiData.getEmail(), loginApiData.getPassword());
		
		if (dbUser.isPresent()) {
			return dbUser.get();
			
		}else {
			return "invalid credentials";
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
