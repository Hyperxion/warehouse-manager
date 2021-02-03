package com.edemko.warehousemanager.service;

import com.edemko.warehousemanager.model.User;

public interface UserService {
    void saveUser(User user);

    User findByUsername(String username);
}
