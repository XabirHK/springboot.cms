package com.zabir.springboot.cms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zabir.springboot.cms.models.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

}
