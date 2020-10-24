package com.zabir.springboot.cms.controllers;

import org.springframework.stereotype.Component;

import com.zabir.springboot.cms.domains.RetData;

@Component
public class Response {
    private Boolean success;
    private Integer errorCode;
    private String errorValue;
    private RetData data;
}