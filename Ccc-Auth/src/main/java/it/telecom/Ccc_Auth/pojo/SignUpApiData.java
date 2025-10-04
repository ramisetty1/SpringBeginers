package it.telecom.Ccc_Auth.pojo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SignUpApiData {
	
	@NotNull(message = "Name required")
	@NotBlank(message = "Name shouldn't be empty")
	@Size(min = 3, message = "Name atleast 3 min char")
	private String name;

	@NotNull(message = "email required")
	@NotBlank(message = "email shouldn't be empty")
	@Email
	private String email;
	
	@NotNull(message = "password required")
	@NotBlank(message = "password shouldn't be empty")
	@Size(min = 8, message = "password atleast 8 min char")
	private String password;
	
	@NotNull(message = "mobileNumber required")
	@NotBlank(message = "mobileNumber shouldn't be empty")
	@Size(min = 10, message = "mobileNumber atleast 10 min char")
	private String mobileNumber;
}
