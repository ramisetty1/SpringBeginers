package it.telecom.CCC_Auth.service;

import org.springframework.stereotype.Service;

import it.telecom.CCC_Auth.pojo.LoginData;
import it.telecom.CCC_Auth.pojo.ResetData;
import it.telecom.CCC_Auth.pojo.SignUpData;

@Service
public class AuthService {
	
	public String login(LoginData loginData) {
		
		String db_email = "ramisetty@gmail.com";
		
		String db_password = "1234567";
		
		
		if (loginData.getEmail() == null) {
			
			return "email should required";
		}
		
		if (loginData.getEmail().length() == 0) {
			
			return "email should not be empty";
		}
		
		 boolean isValid = (loginData.getEmail().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")); 
			
			if (isValid != true) {
				return "email format required"; 
			}
			
			
			
		
		
		
		if (db_email.equals(loginData.getEmail()) && db_password.equals(db_password)) {
		
		
			
			return "login success";
			
		}else {
			
			return"invalid credentials";
		}
		
		}
	
	public String signup(SignUpData signUpData) {
		
		return "Account created";
	}
	
	
	
	public String resetPassword(ResetData resetData) {
		
		return "otp sent to email. please reset your password: " + resetData.getEmail();
		
	}

}
