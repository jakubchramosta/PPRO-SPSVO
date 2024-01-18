package com.example.pprospsvo.services;

import com.example.pprospsvo.model.Vehicle;
import com.example.pprospsvo.repositories.VehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {

    private VehicleRepo vehicleRepo;

    @Autowired
    public VehicleService(VehicleRepo vehicleRepo) {
        this.vehicleRepo = vehicleRepo;
    }

    public void add(Vehicle newVehicle) {
        vehicleRepo.save(newVehicle);
    }
}
