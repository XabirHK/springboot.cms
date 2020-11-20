package com.zabir.springboot.cms.services;

import com.zabir.springboot.cms.models.User;

public interface UserService {
	
	User saveUser(User user);
    User findByUsername(String username);

}
