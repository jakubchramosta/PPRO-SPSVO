package com.example.pprospsvo.cotrollers;

import com.example.pprospsvo.model.RPContainer;
import com.example.pprospsvo.services.RPContainerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class RPContainerController {

    private RPContainerService rpContainerService;

    public RPContainerController(RPContainerService rpContainerService) {
        this.rpContainerService = rpContainerService;
    }

    @GetMapping("/rpContainer")
    public String rpContainer(Model model) {

        List<RPContainer> rpContainerList = rpContainerService.getRPContainers();
        model.addAttribute("rpContainerList", rpContainerList);
        return "rpContainer";
    }
}
