package com.safa.userservice.services.jpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

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

	@Override
	public UserDTO getUserById(Long id) {
		User userEntity = userRepo.findById(id)
				.orElseThrow(() -> new NoSuchElementException("No user found with ID:" + id));
		UserDTO userDto = mapper.map(userEntity, UserDTO.class);

		return userDto;
	}

	@Override
	public List<UserDTO> getAllUsers() {
		List<User> users = new ArrayList<>();
		userRepo.findAll().forEach(users::add);
		List<UserDTO> DtoList = Arrays.asList(mapper.map(users, UserDTO[].class));
		return DtoList;
	}

}
