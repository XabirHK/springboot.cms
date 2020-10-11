package com.zabir.springboot.cms.repositories;
import org.springframework.data.repository.CrudRepository;

import com.zabir.springboot.cms.models.User;

public interface UserRepository extends CrudRepository<User, Integer>{

}
