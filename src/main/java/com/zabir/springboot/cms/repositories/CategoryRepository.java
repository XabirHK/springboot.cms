package com.zabir.springboot.cms.repositories;

import org.springframework.stereotype.Repository;

import com.zabir.springboot.cms.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CategoryRepository extends  JpaRepository <Category, Integer>{
	
}
