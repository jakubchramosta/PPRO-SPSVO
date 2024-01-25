package com.example.pprospsvo.repositories;

import com.example.pprospsvo.model.CollectionTrip;
import com.example.pprospsvo.model.RPContainer;
import com.example.pprospsvo.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CollectionTripRepo extends JpaRepository<CollectionTrip, Integer> {
    List<CollectionTrip> findCollectionTripsByRpContainerListContaining(RPContainer container);
    List<CollectionTrip> findCollectionTripsByUsedVehicle(Vehicle vehicle);
}
