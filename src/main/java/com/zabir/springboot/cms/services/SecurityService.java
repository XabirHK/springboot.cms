package com.zabir.springboot.cms.services;

public interface SecurityService {
	
	String findLoggedInUsername();
    void autoLogin(String username, String password);

}
