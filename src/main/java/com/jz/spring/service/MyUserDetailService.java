package com.jz.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author jz
 * @date 2019/11/4 - 22:00
 */
@Component
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private  PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        Collection<GrantedAuthority> collection=getAuthority();
        String encode = passwordEncoder.encode("12345");


        return new User("admin",encode, collection);
    }

    private Collection<GrantedAuthority> getAuthority(){
        List<GrantedAuthority> list=new ArrayList<>();
        list.add(new SimpleGrantedAuthority("Food"));
        list.add(new SimpleGrantedAuthority("Profile"));

        return list;
    }
}
