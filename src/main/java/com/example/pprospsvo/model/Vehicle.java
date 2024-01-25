package com.example.pprospsvo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue
    private int id;
    private double capacity;
    private boolean available;
    private String licensePlate;
    private String model;
    @ManyToOne
    @JsonBackReference
    private Warehouse warehouse;

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

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public String toString() {
        return " | Model: " + model + "; License plate: " + licensePlate;
    }

    public String getAddressOfWarehouse() {
        if (warehouse != null && warehouse.getAddress() != null) return warehouse.getAddress().toString();
        else return "Not found...";

    }

    public void removeWarehouse() {
        warehouse = null;
    }
}
