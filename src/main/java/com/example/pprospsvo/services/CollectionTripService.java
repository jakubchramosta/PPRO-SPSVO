package com.example.pprospsvo.services;

import com.example.pprospsvo.model.CollectionTrip;
import com.example.pprospsvo.model.Warehouse;
import com.example.pprospsvo.repositories.CollectionTripRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CollectionTripService {

    private CollectionTripRepo collectionTripRepo;

    @Autowired
    public CollectionTripService(CollectionTripRepo collectionTripRepo) {
        this.collectionTripRepo = collectionTripRepo;
    }

    public void add(CollectionTrip newCollectionTrip) {
        collectionTripRepo.save(newCollectionTrip);
    }

    public List<CollectionTrip> getCollectionTrips() {
        return Collections.unmodifiableList(collectionTripRepo.findAll());
    }

    public CollectionTrip getById(int id) {
        return collectionTripRepo.getReferenceById(id);
    }

    public void deleteById(int id) {
        collectionTripRepo.deleteById(id);
    }
}
