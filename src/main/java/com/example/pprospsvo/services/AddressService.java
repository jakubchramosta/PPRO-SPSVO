package com.example.pprospsvo.services;

import com.example.pprospsvo.model.Address;
import com.example.pprospsvo.model.RPContainer;
import com.example.pprospsvo.model.Warehouse;
import com.example.pprospsvo.repositories.AddressRepo;
import com.example.pprospsvo.repositories.RPContainerRepo;
import com.example.pprospsvo.repositories.WarehouseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class AddressService {

    private AddressRepo addressRepo;
    private RPContainerRepo rpContainerRepo;
    private WarehouseRepo warehouseRepo;

    @Autowired
    public AddressService(AddressRepo addressRepo, RPContainerRepo rpContainerRepo, WarehouseRepo warehouseRepo) {
        this.addressRepo = addressRepo;
        this.rpContainerRepo = rpContainerRepo;
        this.warehouseRepo = warehouseRepo;
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
        Address deletedAddress = addressRepo.getReferenceById(id);
        List<RPContainer> containerList = rpContainerRepo.findRPContainersByAddress(deletedAddress);
        List<Warehouse> warehouseList =warehouseRepo.findWarehousesByAddress(deletedAddress);

        for (RPContainer cont : containerList) {
            cont.removeAddress();
        }

        for (Warehouse warehouse : warehouseList) {
            warehouse.removeAddress();
        }

        addressRepo.deleteById(id);
    }
}
