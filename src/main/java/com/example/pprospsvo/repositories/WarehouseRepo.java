package com.example.pprospsvo.repositories;

import com.example.pprospsvo.model.Address;
import com.example.pprospsvo.model.Vehicle;
import com.example.pprospsvo.model.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WarehouseRepo extends JpaRepository<Warehouse, Integer> {
    List<Warehouse> findWarehousesByVehicleListContaining(Vehicle vehicle);
    List<Warehouse> findWarehousesByAddress(Address address);
}
