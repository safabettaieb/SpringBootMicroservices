package com.safa.userservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.safa.userservice.dto.UserDTO;
import com.safa.userservice.services.UserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {

	private UserService userService;

	@Autowired
	private Environment environment;

	@GetMapping({ "", "/", "/welcome" })
	public String welcome() {

		return "User Service runin on port : " + environment.getProperty("local.server.port");
	}
	@GetMapping("/all")
	public List<UserDTO >getAllUsers(){
		return userService.getAllUsers();
	}
	

	@PostMapping("/add")
	public UserDTO addUser(@RequestBody UserDTO userDto) {

		return userService.addUser(userDto);

	}

	@GetMapping("/{id}")
	public UserDTO getUserByIdWithAlbums(@PathVariable Long id) {
		return userService.getUserByIdWithAlbums(id);
	}
}
