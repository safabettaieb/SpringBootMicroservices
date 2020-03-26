package com.safa.userservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.safa.userservice.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	

}
