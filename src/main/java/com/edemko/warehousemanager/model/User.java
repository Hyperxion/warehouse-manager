package com.edemko.warehousemanager.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    @Column
    private String nickname;

    @NotEmpty
    @Column
    private String password;

    @Transient
    @NotEmpty
    private String passwordVerified;

    @Column
    @NotEmpty
    private String email;

    public String getPasswordVerified() {
        return passwordVerified;
    }

    public void setPasswordVerified(String passwordVerified) {
        this.passwordVerified = passwordVerified;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", passwordVerified='" + passwordVerified + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
