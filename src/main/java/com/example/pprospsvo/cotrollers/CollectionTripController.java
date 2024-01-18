package com.example.pprospsvo.cotrollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CollectionTripController {

    @GetMapping("/collectionTrip")
    public String collectionTrip() {
        return "collectionTrip";
    }
}
