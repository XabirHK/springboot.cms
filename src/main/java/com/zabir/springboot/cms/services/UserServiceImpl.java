package com.zabir.springboot.cms.services;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.zabir.springboot.cms.models.User;
import com.zabir.springboot.cms.repositories.RoleRepository;
import com.zabir.springboot.cms.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public User saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findAll()));
		return userRepository.save(user);
    }

    public List<User> saveUsers(List<User> Users) {
        return userRepository.saveAll(Users);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }


    public String deleteUser(int id) {
    	userRepository.deleteById(id);
        return "User removed !! " + id;
    }
    
    
    public User updateUser(User User) {
        User existingUser = userRepository.findById(User.getId()).orElse(null);
        
        existingUser.setName(User.getUsername());
        existingUser.setEmail(User.getEmail());
        existingUser.setRoles(User.getRoles());
       
        return userRepository.save(existingUser);
    }


	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
}
