package com.kipcollo.registration.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Registration")
public class SignIn {

    @GetMapping
    public String signInPage(){
        return "sign In";
    }
}
