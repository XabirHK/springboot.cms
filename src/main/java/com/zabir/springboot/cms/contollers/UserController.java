package com.zabir.springboot.cms.contollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.zabir.springboot.cms.models.User;
import com.zabir.springboot.cms.services.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/add")
    public User addUser(User user) {
        return userService.saveUser(user);
		//return "Add user";
    }

//    @PostMapping("/users/addall")
//    public List<User> addUsers(@RequestBody List<User> users) {
//        return userService.saveUsers(users);
//    }

    @GetMapping("/users")
    public List<User> findAllUsers() {
        return userService.getUsers();
    }

    @GetMapping("/user/{id}")
    public User findUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

//    @GetMapping("/user/{name}")
//    public User findUserByName(@PathVariable String name) {
//        return userService.getUserByName(name);
//    }

    @PutMapping(path = "/update")
    public User updateUser(User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        return userService.deleteUser(id);
    }
}
