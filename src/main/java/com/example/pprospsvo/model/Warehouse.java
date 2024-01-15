package com.example.pprospsvo.model;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {

    private double capacity;
    private double fullness;
    private Address address;
    private List<CollectionTrip> collectionTripList = new ArrayList<>();

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

    public List<CollectionTrip> getCollectionTripList() {
        return collectionTripList;
    }

    public void setCollectionTripList(List<CollectionTrip> collectionTripList) {
        this.collectionTripList = collectionTripList;
    }
}
