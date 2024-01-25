package com.example.pprospsvo.services;

import com.example.pprospsvo.model.CollectionTrip;
import com.example.pprospsvo.model.RPContainer;
import com.example.pprospsvo.model.Warehouse;
import com.example.pprospsvo.repositories.CollectionTripRepo;
import com.example.pprospsvo.repositories.RPContainerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class RPContainerService {

    private RPContainerRepo rpContainerRepo;
    private CollectionTripRepo collectionTripRepo;

    @Autowired
    public RPContainerService(RPContainerRepo rpContainerRepo, CollectionTripRepo collectionTripRepo) {
        this.rpContainerRepo = rpContainerRepo;
        this.collectionTripRepo = collectionTripRepo;
    }

    public void add(RPContainer newContainer) {
        rpContainerRepo.save(newContainer);
    }

    public List<RPContainer> getRPContainers() {
        return Collections.unmodifiableList(rpContainerRepo.findAll());
    }

    public RPContainer getById(int id) {
        return rpContainerRepo.getReferenceById(id);
    }

    public void deleteById(int id) {
        RPContainer deletedCont = rpContainerRepo.getReferenceById(id);
        List<CollectionTrip> collectionTripList = collectionTripRepo.findCollectionTripsByRpContainerListContaining(deletedCont);

        for (CollectionTrip trip : collectionTripList) {
            trip.removeRPContainer(deletedCont);
            collectionTripRepo.save(trip);
        }

        rpContainerRepo.deleteById(id);
    }
}
