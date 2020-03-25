package com.safa.userservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private Environment environment;
	
	@GetMapping({"","/","/welcome"})
	public String welcome() {
		
		return "User Service runin on port : " + environment.getProperty("local.server.port");
	}

}
