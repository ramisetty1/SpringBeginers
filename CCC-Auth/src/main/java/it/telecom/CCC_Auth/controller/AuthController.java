package it.telecom.CCC_Auth.controller;

import java.net.ResponseCache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.telecom.CCC_Auth.pojo.LoginData;
import it.telecom.CCC_Auth.pojo.ResetData;
import it.telecom.CCC_Auth.pojo.SignUpData;
import it.telecom.CCC_Auth.service.AuthService;

@RestController
public class AuthController {
	
	@Autowired
	public AuthService authService;
	
	@PostMapping("v1/login")
	public String login(@RequestBody LoginData loginData) {
		
		String response = authService.login(loginData);
		
		return  response;
	}

	
	
	@PostMapping("v1/create-account")
	public String createAccount(@RequestBody SignUpData signUpData) {
		
		String response =	authService.signup(signUpData);
		return response;
		
	}
	
	@PostMapping("v1/forgetpassword")
	public String forgetPassword(@RequestBody ResetData resetData) {
		
		return authService.resetPassword(resetData);
		
		
	}
}
