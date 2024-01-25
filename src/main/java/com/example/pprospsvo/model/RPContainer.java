package com.example.pprospsvo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Entity
public class RPContainer {

    @Id
    @GeneratedValue
    private int id;
    private float capacity;
    private float fullness;
    @Enumerated(EnumType.STRING)
    private RPType rpType;
    @ManyToOne
    private Address address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getCapacity() {
        return capacity;
    }

    public void setCapacity(float capacity) {
        this.capacity = capacity;
    }

    public float getFullness() {
        return fullness;
    }

    public void setFullness(float fullness) {
        this.fullness = fullness;
    }

    public RPType getRpType() {
        return rpType;
    }

    public void setRpType(RPType rpType) {
        this.rpType = rpType;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String containerToString() {
        if (address != null)return " | Address: " + address.toString() + " RP type: " + rpType.toString();
        else return "Not found...";
    }

    public String containerAddressToString() {
        if (address != null) return address.toString();
        else return "Not found...";
    }

    public void removeAddress() {
        address = null;
    }
}
