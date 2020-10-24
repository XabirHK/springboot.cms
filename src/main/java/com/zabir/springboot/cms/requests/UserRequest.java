package com.zabir.springboot.cms.requests;

import lombok.Data;

@Data
public class UserRequest {
    private String username;
    private String password;
    private String fullname;
    private String email;
}