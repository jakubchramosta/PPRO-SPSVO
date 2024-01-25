package com.example.pprospsvo.services;

import com.example.pprospsvo.model.Address;
import com.example.pprospsvo.repositories.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

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

    public List<Address> getAddresses() {
        return Collections.unmodifiableList(addressRepo.findAll());
    }

    public Address getById(int id) {
        return addressRepo.getReferenceById(id);
    }

    public void deleteById(int id) {
    //Can cause problem if deleted while referenced by other classes
        addressRepo.deleteById(id);
    }
}
