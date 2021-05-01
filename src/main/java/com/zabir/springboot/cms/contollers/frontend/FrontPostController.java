package com.zabir.springboot.cms.contollers.frontend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zabir.springboot.cms.models.Category;
import com.zabir.springboot.cms.models.Post;
import com.zabir.springboot.cms.services.PostService;
import com.zabir.springboot.cms.services.frontend.HomePageService;
import com.zabir.springboot.cms.services.frontend.TopMenuService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("front/api/v1")
public class FrontPostController {
	@Autowired
	private PostService postService;
	
	@GetMapping("/getpost/{id}")
    public Post findPostById(@PathVariable int id) {
        return postService.getPostById(id);
    }
	
	@GetMapping("/getpostbycategory/{id}")
    public List<Post> findPostsByCategoryId(@PathVariable Integer id) {
        return postService.getPostByCategoryId(id);
    }

}
