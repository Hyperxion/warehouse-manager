package com.edemko.warehousemanager.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class User {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long id;
    private String username;
    private String password;
    private String email;
    @Transient
    private String passwordVerified;

    //Roles defines access to other object
    //they are required by spring security
    //cascade type defines how will be child of parent treated - in our case, parent is User and child is roles.
    //whenever we perform so  me of cascade (in this case it is applied to ALL operations) operation on parent
    //it will apply to child too.
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Role> roles;

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
                ", nickname='" + username + '\'' +
                ", password='" + password + '\'' +
                ", passwordVerified='" + passwordVerified + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
