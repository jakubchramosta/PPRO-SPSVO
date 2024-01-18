package com.example.pprospsvo.services;

import com.example.pprospsvo.model.CollectionTrip;
import com.example.pprospsvo.repositories.CollectionTripRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
