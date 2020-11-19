package com.zabir.springboot.cms.repositories;

import org.springframework.stereotype.Repository;
import com.zabir.springboot.cms.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends  JpaRepository <User, Integer>{
	User findByUsername(String username);
}
