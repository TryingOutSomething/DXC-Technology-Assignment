package com.tryingoutsomething.loginapp.web.controller;

import com.tryingoutsomething.loginapp.model.AuthenticatedUser;
import com.tryingoutsomething.loginapp.service.HumanReadableStringFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Controller
public class ViewController {

    @Autowired
    HumanReadableStringFormat<Collection<GrantedAuthority>> roleFormatter;

    @GetMapping("/admin")
    public String getAdminPage() {
        return "admin";
    }

    @GetMapping("/")
    public String getMainPage(Model model, @AuthenticationPrincipal AuthenticatedUser user) {
        model.addAttribute("username", user.getUsername());
        model.addAttribute("name", user.getName());
        model.addAttribute("roles", roleFormatter.format(user.getAuthorities()));
        return "index";
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }
}
