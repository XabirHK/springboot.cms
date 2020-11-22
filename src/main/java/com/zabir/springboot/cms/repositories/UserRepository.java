package com.zabir.springboot.cms.repositories;

import org.springframework.stereotype.Repository;
import com.zabir.springboot.cms.models.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends  JpaRepository <User, Integer>{
	
	Optional<User> findByUsername(String username);
	Boolean existsByUsername(String username);
	Boolean existsByEmail(String email);
	
}
