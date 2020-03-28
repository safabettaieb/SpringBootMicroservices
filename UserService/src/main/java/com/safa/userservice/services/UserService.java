package com.safa.userservice.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.safa.userservice.dto.UserDTO;

public interface UserService extends UserDetailsService{
	public UserDTO addUser(UserDTO user);
	public UserDTO getUserByIdWithAlbums(Long id);
	public List<UserDTO> getAllUsersWithAlbums();
	public UserDTO getUserByEmail(String userEmail);


}
