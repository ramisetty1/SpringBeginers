package it.telecom.Ccc_Auth.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.telecom.Ccc_Auth.entity.User;
import it.telecom.Ccc_Auth.pojo.SignUpApiData;
import it.telecom.Ccc_Auth.pojo.LoginApiData;
import it.telecom.Ccc_Auth.pojo.ProfileUpdateApiData;
import it.telecom.Ccc_Auth.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
public class AuthController {
	
	@Autowired
	public AuthService authService;
	
	@PostMapping("api/signUp")
	public Map<String, Object> createAccount(@Valid @RequestBody SignUpApiData signUpApiData, BindingResult validationResult) {
		
		if  (validationResult.hasErrors() == true) {
			Map<String, Object> errMap = new HashMap<String, Object>();
			
			validationResult.getFieldErrors().forEach(Error-> {
				
				errMap.put("result", "failed");
				errMap.put(Error.getField(), Error.getDefaultMessage());
				
				
			});
			return errMap;
			

		}else {
			
			Map<String,Object> resMap = new HashMap<String, Object>();
			
			User user = authService.signupService(signUpApiData);
			
			resMap.put("result", "success");
			resMap.put("data", user);
			
			return resMap;
			
		}	

	}
	
	@PostMapping("api/profile-update")
	public Object profileUpdate(@RequestBody ProfileUpdateApiData profileUpdateApiData) {
		
		return authService.profileUpdateService(profileUpdateApiData);
		
	}
	
	
	@GetMapping("/api/getDetails/{id}")
	public Object getUserdetails(@PathVariable int id) {
		return authService.getDetails(id) ;
		
		
	}
	
	@PostMapping("/loginwithquery")
	public Object loginWithQuery(@RequestBody LoginApiData loginApiData) {
		
		return authService.loginQuery(loginApiData);
		
		
	}
	
	
	
	
	}
	
	
	
	
	
	
	
 

