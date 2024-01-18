package com.example.pprospsvo.repositories;

import com.example.pprospsvo.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address, Integer> {
}
