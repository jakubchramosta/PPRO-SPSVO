package com.example.pprospsvo.cotrollers;

import com.example.pprospsvo.model.Vehicle;
import com.example.pprospsvo.services.VehicleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class VehicleController {

    private VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/vehicle")
    public String vehicle(Model model) {

        List<Vehicle> vehicleList = vehicleService.getVehicles();
        model.addAttribute("vehicleList", vehicleList);
        return "vehicle";
    }
}
