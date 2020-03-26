package com.safa.userservice.services;

import java.util.List;

import com.safa.userservice.dto.UserDTO;

public interface UserService {
	public UserDTO addUser(UserDTO user);
	public UserDTO getUserById(Long id);
	public List<UserDTO> getAllUsers();

}
