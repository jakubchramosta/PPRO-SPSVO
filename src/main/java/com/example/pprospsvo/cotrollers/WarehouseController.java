package com.example.pprospsvo.cotrollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WarehouseController {

    @GetMapping("/warehouse")
    public String warehouse() {
        return "warehouse";
    }
}
