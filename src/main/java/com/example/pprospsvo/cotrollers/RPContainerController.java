package com.example.pprospsvo.cotrollers;

import com.example.pprospsvo.model.Address;
import com.example.pprospsvo.model.RPContainer;
import com.example.pprospsvo.model.Warehouse;
import com.example.pprospsvo.services.AddressService;
import com.example.pprospsvo.services.RPContainerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class RPContainerController {

    private RPContainerService rpContainerService;
    private AddressService addressService;

    public RPContainerController(RPContainerService rpContainerService, AddressService addressService) {
        this.rpContainerService = rpContainerService;
        this.addressService = addressService;
    }

    @GetMapping("/rpContainer")
    public String rpContainer(Model model) {

        List<RPContainer> rpContainerList = rpContainerService.getRPContainers();
        model.addAttribute("rpContainerList", rpContainerList);
        return "rpContainer";
    }

    @GetMapping("/newRPContainer")
    public String newRPContainer(Model model) {
        RPContainer tempRPContainer =  new RPContainer();
        List<Address> addressList = addressService.getAddresses();

        model.addAttribute("rpContainer", tempRPContainer);
        model.addAttribute("addressList", addressList);

        return "newRPContainer";
    }

    @PostMapping("/newRPContainer")
    public String newRPContainer(
            RPContainer rpContainer
    ) {
        rpContainerService.add(rpContainer);

        return "redirect:/rpContainer";
    }

    @GetMapping("/editRPContainer")
    public String editRPContainer(int id, Model model) throws Exception {

        RPContainer rpContainer = rpContainerService.getById(id);
        List<Address> addressList = addressService.getAddresses();

        if (rpContainer != null) {
            model.addAttribute("rpContainer", rpContainer);
            model.addAttribute("addressList", addressList);
            return "editRPContainer";
        }
        else throw new Exception("Container with id " + id + " does not exist.");
    }

    @PostMapping("/editRPContainer")
    public String editRPContainer(
            int id,
            RPContainer rpContainer
    ) {
        rpContainer.setId(id);
        rpContainerService.add(rpContainer);

        return "redirect:/rpContainer";
    }

    @RequestMapping(value = "/deleteRPContainer", method = RequestMethod.DELETE)
    public String deleteRPContainer(int id) {
        rpContainerService.deleteById(id);
        return "redirect:/rpContainer";
    }
}
