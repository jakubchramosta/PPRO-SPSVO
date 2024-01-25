package com.example.pprospsvo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Warehouse {

    @Id
    @GeneratedValue
    private int id;
    private double capacity;
    private double fullness;
    @OneToOne
    private Address address;
    @OneToMany(mappedBy = "warehouse")
    @JsonBackReference
    private List<Vehicle> vehicleList = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public double getFullness() {
        return fullness;
    }

    public void setFullness(double fullness) {
        this.fullness = fullness;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    public String vehicleListToString() {
        String list = "";

        for (Vehicle vehicle : vehicleList) {

            list += vehicle.toString();
        }

        return list;
    }

    public String getCity() {
        if (address != null) return address.getCity();
        else return "Not found...";
    }
}
