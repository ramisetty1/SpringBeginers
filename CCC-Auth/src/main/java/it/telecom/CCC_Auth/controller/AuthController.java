package it.telecom.CCC_Auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.telecom.CCC_Auth.pojo.LoginData;
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

}
