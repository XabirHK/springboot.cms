package com.zabir.springboot.cms.repositories;

import org.springframework.stereotype.Repository;

import com.zabir.springboot.cms.models.Category;
import com.zabir.springboot.cms.models.Post;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PostRepository extends  JpaRepository <Post, Integer>{
	List<Post> findTop4ByOrderByCreatedDesc();

	List<Post> findByCategory(Integer category);
	
}
