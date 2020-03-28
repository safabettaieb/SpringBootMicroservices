package com.safa.userservice.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.Data;


@Entity
@Data
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	@Column(nullable = false , length = 30)
	private String name;
	
	@Column(nullable = false , length = 30, unique = true)
	private String email;
	
	private String password;
	
	@Transient
	private BCryptPasswordEncoder Bcryptencoder = new BCryptPasswordEncoder();
	
	public void setPassword(String password) {
		this.password = Bcryptencoder.encode(password);
	}

}
