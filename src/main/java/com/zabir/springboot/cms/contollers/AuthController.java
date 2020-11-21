package com.zabir.springboot.cms.contollers;

import java.io.Console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.zabir.springboot.cms.models.User;
import com.zabir.springboot.cms.services.SecurityService;
import com.zabir.springboot.cms.services.UserService;
import com.zabir.springboot.cms.validator.UserValidator;

@Controller
public class AuthController {
	@Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @GetMapping("/signup")
    public String signup(Model model) {
    	System.out.println("DhukseRegGet");
        model.addAttribute("userForm", new User());
        
        return "/signup";
    }

    @PostMapping("/signup")
    public String signup(User user, BindingResult bindingResult) {
    	System.out.println("DhukseRegPost");
        userValidator.validate(user, bindingResult);
        System.out.println("Dhukse");
        if (bindingResult.hasErrors()) {
        	System.out.println("Sign up error dhukse");
            return "/signup";
        }

        userService.saveUser(user);

        securityService.autoLogin(user.getUsername(), user.getPasswordConfirm());

        return "redirect:/welcome";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
    	System.out.println("DhukseLoginGet3333");
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "/login";
    }

    @GetMapping({"/", "/welcome"})
    public String welcome(Model model) {
    	System.out.println("DhukseWelcomeGet");
        return "/welcome";
    }

}
