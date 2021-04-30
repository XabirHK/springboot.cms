package com.zabir.springboot.cms.repositories;

import org.springframework.stereotype.Repository;

import com.zabir.springboot.cms.models.Category;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.spel.spi.Function;

@Repository
public interface CategoryRepository extends  JpaRepository <Category, Integer>{
	List<Category> findByPositionAndStatusAndLanguage(String position, Integer status, Integer language);
}
