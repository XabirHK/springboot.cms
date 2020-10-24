package com.zabir.springboot.cms.common;

public class NotFoundException extends Exception {
    private String message;

    public NotFoundException(String msg) {
        this.message = msg;
    }

}