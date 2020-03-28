package com.safa.userservice.services.jpa;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.safa.userservice.dto.AlbumDTO;
import com.safa.userservice.dto.UserDTO;
import com.safa.userservice.entities.User;
import com.safa.userservice.feigns.AlbumServiceProxy;
import com.safa.userservice.repositories.UserRepository;
import com.safa.userservice.services.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImp implements UserService {

	private UserRepository userRepo;
	private ModelMapper mapper;
	private AlbumServiceProxy albumServiceProxy;

	@Override
	public UserDTO addUser(UserDTO userDTO) {
		User userEntity = mapper.map(userDTO, User.class);
		userRepo.save(userEntity);
		return userDTO;
	}

	@Override
	public UserDTO getUserByIdWithAlbums(Long id) {
		User userEntity = userRepo.findById(id)
				.orElseThrow(() -> new NoSuchElementException("No user found with ID:" + id));
		List<AlbumDTO> albums = albumServiceProxy.getUserAlbums(id);

		UserDTO userDto = mapper.map(userEntity, UserDTO.class);
		userDto.setAlbums(albums);

		return userDto;
	}

	@Override
	public List<UserDTO> getAllUsersWithAlbums() {
		List<UserDTO> usersDTO = new ArrayList<>();
		userRepo.findAll().forEach((u)-> {
			List<AlbumDTO> albums = albumServiceProxy.getUserAlbums(u.getUserId());
			UserDTO userDTO = mapper.map(u, UserDTO.class);
			userDTO.setAlbums(albums);
			usersDTO.add(userDTO);
		});
		return usersDTO;
	}

	@Override
	public UserDTO getUserByEmail(String userEmail) {
		
		User userEntity =userRepo.findByEmail(userEmail).orElseThrow(() -> new NoSuchElementException("No user found with EMAIL:" + userEmail));
		UserDTO userDTO = mapper.map(userEntity, UserDTO.class);
		return userDTO;
	}

	@Override
	public UserDetails loadUserByUsername(String username) {
		User userEntity =userRepo.findByEmail(username).orElseThrow(() -> new NoSuchElementException("No user found with EMAIL:" + username));
		return new org.springframework.security.core.userdetails.User(userEntity.getEmail(), userEntity.getPassword(), true, true, true, true, new ArrayList<>());
	}

}
