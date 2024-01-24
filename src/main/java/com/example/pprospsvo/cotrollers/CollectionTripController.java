package com.example.pprospsvo.cotrollers;

import com.example.pprospsvo.model.*;
import com.example.pprospsvo.services.CollectionTripService;
import com.example.pprospsvo.services.RPContainerService;
import com.example.pprospsvo.services.VehicleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class CollectionTripController {

    private CollectionTripService collectionTripService;
    private VehicleService vehicleService;
    private RPContainerService rpContainerService;

    public CollectionTripController(
            CollectionTripService collectionTripService,
            VehicleService vehicleService,
            RPContainerService rpContainerService
    ) {
        this.collectionTripService = collectionTripService;
        this.vehicleService = vehicleService;
        this.rpContainerService = rpContainerService;
    }

    @GetMapping("/collectionTrip")
    public String collectionTrip(Model model) {

        List<CollectionTrip> collectionTripList = collectionTripService.getCollectionTrips();
        model.addAttribute("collectionTripList", collectionTripList);
        return "collectionTrip";
    }

    @GetMapping("/newCollectionTrip")
    public String newCollectionTrip(Model model) {
        CollectionTrip tempCollectionTrip =  new CollectionTrip();
        List<Vehicle> vehicleList = vehicleService.getVehicles();
        List<RPContainer> rpContainerList = rpContainerService.getRPContainers();

        model.addAttribute("collectionTrip", tempCollectionTrip);
        model.addAttribute("vehicleList", vehicleList);
        model.addAttribute("rpContainerList", rpContainerList);

        return "newCollectionTrip";
    }

    @PostMapping("/newCollectionTrip")
    public String newCollectionTrip(
            CollectionTrip collectionTrip
    ) {
        collectionTripService.add(collectionTrip);

        return "redirect:/collectionTrip";
    }

    @GetMapping("/editCollectionTrip")
    public String editCollectionTrip(int id, Model model) throws Exception {

        CollectionTrip collectionTrip = collectionTripService.getById(id);
        List<Vehicle> vehicleList = vehicleService.getVehicles();
        List<RPContainer> rpContainerList = rpContainerService.getRPContainers();

        if (collectionTrip != null) {
            model.addAttribute("collectionTrip", collectionTrip);
            model.addAttribute("vehicleList", vehicleList);
            model.addAttribute("rpContainerList", rpContainerList);
            return "editCollectionTrip";
        }
        else throw new Exception("Warehouse with id " + id + " does not exist.");
    }

    @PostMapping("/editCollectionTrip")
    public String editCollectionTrip(
            int id,
            CollectionTrip collectionTrip
    ) {
        collectionTrip.setId(id);
        collectionTripService.add(collectionTrip);

        return "redirect:/collectionTrip";
    }

    @RequestMapping(value = "/deleteCollectionTrip", method = RequestMethod.DELETE)
    public String deleteCollectionTrip(int id) {
        collectionTripService.deleteById(id);
        return "redirect:/collectionTrip";
    }
}
