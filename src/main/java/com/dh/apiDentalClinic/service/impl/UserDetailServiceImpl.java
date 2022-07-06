package com.dh.apiDentalClinic.service.impl;

import com.dh.apiDentalClinic.entity.login.PrincipalUser;
import com.dh.apiDentalClinic.entity.login.User;
import com.dh.apiDentalClinic.service.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    UserService userService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUserName(username).get();
        return PrincipalUser.build(user);
    }
}
