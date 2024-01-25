package com.example.pprospsvo.services;

import com.example.pprospsvo.model.CollectionTrip;
import com.example.pprospsvo.model.Vehicle;
import com.example.pprospsvo.model.Warehouse;
import com.example.pprospsvo.repositories.CollectionTripRepo;
import com.example.pprospsvo.repositories.VehicleRepo;
import com.example.pprospsvo.repositories.WarehouseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class VehicleService {

    private VehicleRepo vehicleRepo;
    private CollectionTripRepo collectionTripRepo;
    private WarehouseRepo warehouseRepo;

    @Autowired
    public VehicleService(VehicleRepo vehicleRepo, CollectionTripRepo collectionTripRepo, WarehouseRepo warehouseRepo) {
        this.vehicleRepo = vehicleRepo;
        this.collectionTripRepo = collectionTripRepo;
        this.warehouseRepo = warehouseRepo;
    }

    public void add(Vehicle newVehicle) {
        vehicleRepo.save(newVehicle);
    }

    public List<Vehicle> getVehicles() {
        return Collections.unmodifiableList(vehicleRepo.findAll());
    }

    public Vehicle getById(int id) {
        return vehicleRepo.getReferenceById(id);
    }

    public void deleteById(int id) {
        Vehicle deletedVehicle = vehicleRepo.getReferenceById(id);
        List<CollectionTrip> tripList = collectionTripRepo.findCollectionTripsByUsedVehicle(deletedVehicle);
        List<Warehouse> warehouseList = warehouseRepo.findWarehousesByVehicleListContaining(deletedVehicle);

        for (CollectionTrip trip : tripList) {
            trip.removeVehicle();
        }

        for (Warehouse warehouse : warehouseList) {
            warehouse.removeVehicle(deletedVehicle);
        }

        vehicleRepo.deleteById(id);
    }
}
