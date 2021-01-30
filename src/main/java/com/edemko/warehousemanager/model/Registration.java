package com.edemko.warehousemanager.model;

import javax.validation.constraints.NotEmpty;

public class Registration {

    @NotEmpty
    private String nickname;
    @NotEmpty
    private String password;
    @NotEmpty
    private String passwordVerified;
    @NotEmpty
    private String email;

    public String getPasswordVerified() {
        return passwordVerified;
    }

    public void setPasswordVerified(String passwordVerified) {
        this.passwordVerified = passwordVerified;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
