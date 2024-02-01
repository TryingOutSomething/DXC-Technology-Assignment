package com.tryingoutsomething.loginapp.service;

import com.tryingoutsomething.loginapp.utils.Constants;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class RoleFormatter implements HumanReadableStringFormat<Collection<GrantedAuthority>> {

    @Override
    public String formatString(String text) {
        return "";
    }

    @Override
    public Collection<String> format(Collection<GrantedAuthority> t) {
        List<String> roles = new ArrayList<>();

        for (GrantedAuthority authority : t) {
            roles.add(stripPrefix(authority.getAuthority()));
        }

        return roles;
    }

    private String stripPrefix(String role) {
        return role.contains(Constants.ROLE_PREFIX)
                ? role.substring(Constants.ROLE_PREFIX.length())
                : role;
    }
}
