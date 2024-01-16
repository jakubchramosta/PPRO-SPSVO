package com.example.pprospsvo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue
    private int id;
    //RP -> return packaging
    private double capacity;
    private boolean available;
    private String licensePlate;
    private String model;
    @Enumerated(EnumType.STRING)
    private RPType rpType;
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

    public RPType getRpType() {
        return rpType;
    }

    public void setRpType(RPType rpType) {
        this.rpType = rpType;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }
}
