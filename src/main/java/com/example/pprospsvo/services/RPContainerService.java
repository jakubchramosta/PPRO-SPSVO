package com.example.pprospsvo.services;

import com.example.pprospsvo.model.RPContainer;
import com.example.pprospsvo.repositories.RPContainerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
