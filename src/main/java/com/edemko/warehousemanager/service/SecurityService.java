package com.edemko.warehousemanager.service;

public interface SecurityService {
    boolean isAuthenticated();
    void autoLogin(String username, String password);
}
