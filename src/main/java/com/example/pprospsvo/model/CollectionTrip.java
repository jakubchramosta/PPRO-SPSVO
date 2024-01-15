package com.example.pprospsvo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CollectionTrip {

    private Date tripDate;
    private Vehicle usedVehicle;
    private List<RPContainer> rpContainerList = new ArrayList<>();

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
