package com.edemko.warehousemanager.service;

import com.edemko.warehousemanager.model.User;
import com.edemko.warehousemanager.repository.RoleRepository;
import com.edemko.warehousemanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void saveUser(User user) {
        System.out.println("User to be saved:" + user.getUsername() + ";" + user.getPassword());
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        System.out.println("User password encrypted and saved: " + user.getUsername() + ";" + user.getPassword());
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String nickname) {
        return userRepository.findByUsername(nickname);
    }
}
