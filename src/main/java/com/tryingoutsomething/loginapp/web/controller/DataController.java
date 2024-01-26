package com.tryingoutsomething.loginapp.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DataController {

    @GetMapping("/manager/message")
    public String getManagerMessage() {
        return "THIS IS A SUPER SECRET ADMIN PAGE FOR MANAGERS ONLY";
    }
}
