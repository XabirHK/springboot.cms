package com.zabir.springboot.cms.contollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.zabir.springboot.cms.models.Post;
import com.zabir.springboot.cms.services.PostService;

@RestController
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@PostMapping("post/add")
    public Post addPost(Post post) {
        return postService.savePost(post);
    }

//    @PostMapping("/post/addall")
//    public List<Post> addPosts(@RequestBody List<Post> posts) {
//        return postService.savePosts(posts);
//    }

    @GetMapping("/posts")
    public List<Post> findAllPosts() {
        return postService.getPosts();
    }

    @GetMapping("/post/{id}")
    public Post findPostById(@PathVariable int id) {
        return postService.getPostById(id);
    }

//    @GetMapping("/post/{name}")
//    public Post findPostByName(@PathVariable String name) {
//        return postService.getPostByName(name);
//    }

    @PutMapping("post/update")
    public Post updatePost(Post post) {
        return postService.updatePost(post);
    }

    @DeleteMapping("post/delete/{id}")
    public String deletePost(@PathVariable int id) {
        return postService.deletePost(id);
    }
}
