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
