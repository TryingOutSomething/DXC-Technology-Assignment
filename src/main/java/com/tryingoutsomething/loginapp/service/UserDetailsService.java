package com.tryingoutsomething.loginapp.service;

import com.tryingoutsomething.loginapp.model.Role;
import com.tryingoutsomething.loginapp.model.User;
import com.tryingoutsomething.loginapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.searchUserByUsername(username);
        org.springframework.security.core.userdetails.UserDetails userDetails;

        if (user == null) {
            userDetails = new org.springframework.security.core.userdetails.User(
                    "", "", true, true, true,
                    true, List.of(new SimpleGrantedAuthority("ROLE_USER"))
            );
        } else {
            userDetails = new org.springframework.security.core.userdetails.User(
                    user.getUsername(),
                    user.getPassword(),
                    user.isEnabled(),
                    user.isAccountExpired(),
                    user.isCredentialsExpired(),
                    user.isLocked(),
                    getUserAuthorities(user.getRoles())
            );
        }

        return userDetails;
    }

    private Collection<? extends GrantedAuthority> getUserAuthorities(Collection<Role> roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();

        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return authorities;
    }
}
