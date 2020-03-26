package com.safa.userservice.services.jpa;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.safa.userservice.dto.UserDTO;
import com.safa.userservice.entities.User;
import com.safa.userservice.repositories.UserRepository;
import com.safa.userservice.services.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImp implements UserService {

	private UserRepository userRepo;
	private ModelMapper mapper;

	@Override
	public UserDTO addUser(UserDTO userDTO) {
		User userEntity = mapper.map(userDTO, User.class);
        userRepo.save(userEntity);
		return userDTO;
	}

}
