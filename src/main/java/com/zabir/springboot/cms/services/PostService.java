package com.zabir.springboot.cms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zabir.springboot.cms.models.Post;
import com.zabir.springboot.cms.repositories.PostRepository;


@Service
public class PostService {
	@Autowired
	private PostRepository postRepository;
	
	public Post savePost(Post post) {
		 return postRepository.save(post);
    }

    public List<Post> savePosts(List<Post> Posts) {
        return postRepository.saveAll(Posts);
    }

    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    public Post getPostById(int id) {
        return postRepository.findById(id).orElse(null);
    }

//    public Post getPostByName(String name) {
//        return postRepository.findByName(name);
//    }

    public String deletePost(int id) {
    	postRepository.deleteById(id);
        return "Post removed !! " + id;
    }
    
    
    public Post updatePost(Post Post) {
        Post existingPost = postRepository.findById(Post.getId()).orElse(null);

        existingPost.setTitle(Post.getTitle());
        existingPost.setDescription(Post.getDescription());
        existingPost.setCategory(Post.getCategory());
        existingPost.setTags(Post.getTags());
        existingPost.setLanguage(Post.getLanguage());
        existingPost.setPrimaryPicture(Post.getPrimaryPicture());
       
        return postRepository.save(existingPost);
    }
}
