package com.example.pprospsvo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Address {

    @Id
    @GeneratedValue
    private int id;
    private int postalCode;
    @NotNull
    private String city;
    @NotNull
    private String street;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "ZIP: " + postalCode + "; City: " + city + "; Street: " + street;
    }
}
