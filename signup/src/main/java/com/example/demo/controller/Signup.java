package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.SignupApiData;

import jakarta.validation.Valid;

@RestController
public class Signup {

	
	@PostMapping("signup")
	public Object createAccount(@Valid @RequestBody SignupApiData signupApiData) {
		
		return signupApiData;
	}
}
