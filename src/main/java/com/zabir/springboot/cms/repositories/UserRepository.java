package com.zabir.springboot.cms.repositories;

import org.springframework.stereotype.Repository;
import com.zabir.springboot.cms.models.AdminUser;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends  JpaRepository <AdminUser, Integer>{
	
	Optional<AdminUser> findByUsername(String username);
	Boolean existsByUsername(String username);
	Boolean existsByEmail(String email);
	
}
