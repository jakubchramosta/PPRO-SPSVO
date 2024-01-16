package com.example.pprospsvo.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class CollectionTrip {

    @Id
    @GeneratedValue
    private int id;
    private Date tripDate;
    @OneToOne
    private Vehicle usedVehicle;
    @ManyToMany
    private List<RPContainer> rpContainerList = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTripDate() {
        return tripDate;
    }

    public void setTripDate(Date tripDate) {
        this.tripDate = tripDate;
    }

    public Vehicle getUsedVehicle() {
        return usedVehicle;
    }

    public void setUsedVehicle(Vehicle usedVehicle) {
        this.usedVehicle = usedVehicle;
    }

    public List<RPContainer> getRpContainerList() {
        return rpContainerList;
    }

    public void setRpContainerList(List<RPContainer> rpContainerList) {
        this.rpContainerList = rpContainerList;
    }
}
