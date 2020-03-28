package com.safa.userservice.dto;


import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
	@Email(message = "email should have a valid email")
	private String email;
	
	@Pattern(regexp = "$[0-9]{6-8}^")
	private String password;

}
