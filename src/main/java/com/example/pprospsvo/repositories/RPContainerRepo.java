package com.example.pprospsvo.repositories;

import com.example.pprospsvo.model.Address;
import com.example.pprospsvo.model.RPContainer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RPContainerRepo extends JpaRepository<RPContainer, Integer> {
    List<RPContainer> findRPContainersByAddress(Address address);
}
