package com.zabir.springboot.cms.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.zabir.springboot.cms.models.User;
import com.zabir.springboot.cms.services.UserService;

@Component
public class UserValidator implements Validator{
	
	@Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }
    
    
    @Override
    public void validate(Object o, Errors errors) {
    	System.out.println("Dhukse333");
        User user = (User) o;
        System.out.println("Dhukse222");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        
        
        
        System.out.println("Username is---- " + user.getUsername());
        
        if (userService.findByUsername(user.getUsername()) != null) {
        	System.out.println("Username error dhukse");
            errors.rejectValue("username", "Duplicate.user.username");
        }
        
        if (user.getUsername().length() < 3 || user.getUsername().length() > 32) {
            errors.rejectValue("username", "Size.user.username");
        }
        
        
        System.out.println("Password is---- " + user.getPassword().toString());
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 6 || user.getPassword().length() > 32) {
        	System.out.println("Pass error dhukse");
            errors.rejectValue("password", "Size.user.password");
        }

        if (!user.getPasswordConfirm().equals(user.getPassword())) {
        	System.out.println("ComPass error dhukse");
            errors.rejectValue("passwordConfirm", "Diff.user.passwordConfirm");
        }
    }

}
