package com.example.pprospsvo.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class CollectionTrip {

    @Id
    @GeneratedValue
    private int id;
    @Temporal(TemporalType.DATE)
    private LocalDate tripDate;
    @ManyToOne
    private Vehicle usedVehicle;
    @ManyToMany
    private List<RPContainer> rpContainerList = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getTripDate() {
        return tripDate;
    }

    public void setTripDate(LocalDate tripDate) {
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

    public String containerListToString() {
        String list = "";

        for (RPContainer container : rpContainerList) {
            list += container.containerToString();
        }

        return list;
    }

    public void removeRPContainer(RPContainer container) {
        rpContainerList.remove(container);
    }

    public void removeVehicle() {
        usedVehicle = null;
    }

    public String usedVehicleToString() {
        if (usedVehicle != null) return usedVehicle.toString();
        else return "Not found...";
    }
}
