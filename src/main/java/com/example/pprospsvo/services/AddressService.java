package com.example.pprospsvo.services;

import com.example.pprospsvo.model.Address;
import com.example.pprospsvo.repositories.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private AddressRepo addressRepo;

    @Autowired
    public AddressService(AddressRepo addressRepo) {
        this.addressRepo = addressRepo;
    }

    public void add(Address newAddress) {
        addressRepo.save(newAddress);
    }
}
