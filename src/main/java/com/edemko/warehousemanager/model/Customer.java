package com.edemko.warehousemanager.model;

//customer defined here is just a help class for sell order. It will not be saved into database.
//This class is used only to help format and display particular properties of customer
public class Customer {

    private String name;
    private String street;
    private String city;
    private String postalCode;
    private String email;
    private String phoneNumber;

    public Customer(String name, String street, String city, String postalCode, String email, String phoneNumber) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
