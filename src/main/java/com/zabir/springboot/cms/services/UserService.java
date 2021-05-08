package com.zabir.springboot.cms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zabir.springboot.cms.models.AdminUser;
import com.zabir.springboot.cms.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public AdminUser saveUser(AdminUser user) {
		 return userRepository.save(user);
    }

    public List<AdminUser> saveUsers(List<AdminUser> Users) {
        return userRepository.saveAll(Users);
    }

    public List<AdminUser> getUsers() {
        return userRepository.findAll();
    }

    public AdminUser getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

//    public User getUserByName(String name) {
//        return userRepository.findByName(name);
//    }

    public String deleteUser(int id) {
    	userRepository.deleteById(id);
        return "User removed !! " + id;
    }
    
    
    public AdminUser updateUser(AdminUser User) {
        AdminUser existingUser = userRepository.findById(User.getId()).orElse(null);
        
        //return User.getName();
        
        existingUser.setUsername(User.getUsername());
        existingUser.setEmail(User.getEmail());
        existingUser.setRole(User.getRole());
       
        return userRepository.save(existingUser);
    }
}
