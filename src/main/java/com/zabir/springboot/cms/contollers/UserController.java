package com.zabir.springboot.cms.contollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.zabir.springboot.cms.models.User;
import com.zabir.springboot.cms.services.UserServiceImpl;

@RestController
public class UserController {
	
	@Autowired
	private UserServiceImpl userService;
	
	@PostMapping("user/add")
    public User addUser(User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/users")
    public List<User> findAllUsers() {
        return userService.getUsers();
    }

    @GetMapping("/user/{id}")
    public User findUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }


    @PutMapping("user/update")
    public User updateUser(User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("user/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        return userService.deleteUser(id);
    }
    
}
