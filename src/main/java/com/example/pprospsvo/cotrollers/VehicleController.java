package com.example.pprospsvo.cotrollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VehicleController {

    @GetMapping("/vehicle")
    public String vehicle() {
        return "vehicle";
    }
}
