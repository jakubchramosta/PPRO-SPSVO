package com.example.pprospsvo.cotrollers;

import com.example.pprospsvo.model.RPContainer;
import com.example.pprospsvo.model.RPType;
import com.example.pprospsvo.services.RPContainerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerTest {

    private RPContainerService rpContainerService;

    public ControllerTest(RPContainerService rpContainerService) {
        this.rpContainerService = rpContainerService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/dbTest")
    public String dbTest(){
        RPContainer testContainer = new RPContainer();
        testContainer.setRpType(RPType.Plechovky_hliník);
        testContainer.setFullness(100);

        rpContainerService.add(testContainer);

        return "dbTest";
    }
}