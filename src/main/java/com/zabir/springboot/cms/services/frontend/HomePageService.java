package com.zabir.springboot.cms.services.frontend;

import java.util.Date;
import java.util.List;

import javax.persistence.PostRemove;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zabir.springboot.cms.models.Category;
import com.zabir.springboot.cms.models.Post;
import com.zabir.springboot.cms.repositories.CategoryRepository;
import com.zabir.springboot.cms.repositories.PostRepository;

@Service
public class HomePageService {
	@Autowired
	private PostRepository postRepository;
	
	//Date created, Integer status, Integer language
    public List<Post> getHighLitedPosts() {
        return postRepository.findTop4ByOrderByCreatedDesc();
    }

}

