package com.zabir.springboot.cms.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zabir.springboot.cms.models.ERole;
import com.zabir.springboot.cms.models.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{
	Optional<Role> findByName(ERole name);
}
