package com.example.pprospsvo.services;

import com.example.pprospsvo.model.RPContainer;
import com.example.pprospsvo.model.Warehouse;
import com.example.pprospsvo.repositories.RPContainerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class RPContainerService {

    private RPContainerRepo rpContainerRepo;

    @Autowired
    public RPContainerService(RPContainerRepo rpContainerRepo) {
        this.rpContainerRepo = rpContainerRepo;
    }

    public void add(RPContainer newContainer) {
        rpContainerRepo.save(newContainer);
    }

    public List<RPContainer> getRPContainers() {
        return Collections.unmodifiableList(rpContainerRepo.findAll());
    }

    public RPContainer getById(int id) {
        return rpContainerRepo.getReferenceById(id);
    }
}
