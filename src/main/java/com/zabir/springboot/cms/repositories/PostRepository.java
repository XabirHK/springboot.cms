package com.zabir.springboot.cms.repositories;

import org.springframework.stereotype.Repository;

import com.zabir.springboot.cms.models.Post;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PostRepository extends  JpaRepository <Post, Integer>{
	
}
