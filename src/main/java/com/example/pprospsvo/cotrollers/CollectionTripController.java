package com.example.pprospsvo.cotrollers;

import com.example.pprospsvo.model.CollectionTrip;
import com.example.pprospsvo.services.CollectionTripService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CollectionTripController {

    private CollectionTripService collectionTripService;

    public CollectionTripController(CollectionTripService collectionTripService) {
        this.collectionTripService = collectionTripService;
    }

    @GetMapping("/collectionTrip")
    public String collectionTrip(Model model) {

        List<CollectionTrip> collectionTripList = collectionTripService.getCollectionTrips();
        model.addAttribute("collectionTripList", collectionTripList);
        return "collectionTrip";
    }
}
