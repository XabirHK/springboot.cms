package com.zabir.springboot.cms.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;
import javax.validation.Valid;
import com.zabir.springboot.cms.requests.*;
import com.zabir.springboot.cms.services.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/auth")
public class AuthNZController {
    // Following: https://bezkoder.com/spring-boot-jwt-authentication/#Overview_of_Spring_Boot_JWT_Authentication_example

    @Autowired
    UserDetailsService userService;

    @PostMapping("/signup")
    @ResponseBody
    private Response signup(@Valid @RequestBody UserRequest request) {
        // ToDo: process
        log.info("got a signup call, will process in when i have time...");
        return new Response();
    }

    @PostMapping("/signin")
    @ResponseBody
    private Response signin(@Valid @RequestBody UserRequest request) {
        // ToDo: process
        return new Response();
    }
}