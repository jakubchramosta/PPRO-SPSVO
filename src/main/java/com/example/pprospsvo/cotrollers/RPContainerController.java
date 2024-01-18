package com.example.pprospsvo.cotrollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RPContainerController {

    @GetMapping("/rpContainer")
    public String rpContainer() {
        return "rpContainer";
    }
}
