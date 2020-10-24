package com.zabir.springboot.cms.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.zabir.springboot.cms.domains.User;
import com.zabir.springboot.cms.common.*;

public interface UserDetailsService {
    User loadUserByUsername(String username) throws NotFoundException;
    User getUserByUsernameOrEmail(String username, String email) throws NotFoundException;
}