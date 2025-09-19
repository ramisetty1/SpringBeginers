package com.example.demo.pojo;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Data
public class SignupApiData {
	
	
	@NotNull(message = "name required")
	@Size(min = 5, message = "should be minimum 5 char")
	public String name;
	
	@NotNull(message = "email required")
	public String email;
	
	@NotNull(message = "password required")
	public String password;
	
	

}
