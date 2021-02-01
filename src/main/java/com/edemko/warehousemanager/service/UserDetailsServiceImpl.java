package com.edemko.warehousemanager.service;

import com.edemko.warehousemanager.model.Role;
import com.edemko.warehousemanager.model.User;
import com.edemko.warehousemanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
/*
To implement login/authentication with Spring Security, we need to implement UserDetailsService interface.
Implementation of UserDetailsService is where the authority mapping takes place. Once the user has authenticated,
our loadUserByUsername method populates and returns a User object
 */

public class UserDetailsServiceImpl implements UserDetailsService{
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String nickname) {
        User user = userRepository.findByNickname(nickname);
        //if user does not exist, throws pre-defined exception in spring security framework
        if (user == null) throw new UsernameNotFoundException(nickname);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : user.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return new org.springframework.security.core.userdetails.User(user.getNickname(), user.getPassword(), grantedAuthorities);
    }
}
