package com.example.pprospsvo.repositories;

import com.example.pprospsvo.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepo extends JpaRepository<Vehicle, Integer> {
}
