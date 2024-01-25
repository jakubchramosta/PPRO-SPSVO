package com.example.pprospsvo.repositories;

import com.example.pprospsvo.model.Address;
import com.example.pprospsvo.model.Vehicle;
import com.example.pprospsvo.model.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepo extends JpaRepository<Vehicle, Integer> {
    List<Vehicle> findVehiclesByWarehouse(Warehouse warehouse);
}
