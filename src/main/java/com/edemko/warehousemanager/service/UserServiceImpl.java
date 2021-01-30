package com.edemko.warehousemanager.service;

import com.edemko.warehousemanager.model.User;
import com.edemko.warehousemanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void saveUser(User user) {
        this.userRepository.save(user);
    }
}
