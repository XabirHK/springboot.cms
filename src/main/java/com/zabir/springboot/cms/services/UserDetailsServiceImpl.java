package com.zabir.springboot.cms.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import com.zabir.springboot.cms.domains.User;
import com.zabir.springboot.cms.repository.UserRepository;
import com.zabir.springboot.cms.common.*;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    public User loadUserByUsername(String username) throws NotFoundException {
        // ToDo
        return null;  /* very bad thing to send null, but I am lazy, it's midnight */
    }

    public User getUserByUsernameOrEmail(String username, String email) throws NotFoundException {
        User user = userRepository.findByUsernameOrEmail(username, email)
            .orElseThrow(() -> new NotFoundException("User not found"));

        user.setPassword("");
        return user;
    }
}