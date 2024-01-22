package com.example.pprospsvo.cotrollers;

import com.example.pprospsvo.model.Address;
import com.example.pprospsvo.services.AddressService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/address")
    public String address(Model model) {

        List<Address> addressList = addressService.getAddresses();
        model.addAttribute("addresses", addressList);
        return "address";
    }

    @GetMapping("/newAddress")
    public String newAddress(Model model) {
        Address tempAdd =  new Address();
        model.addAttribute(tempAdd);

        return "newAddress";
    }

    @PostMapping("/newAddress")
    public String newAddress(
            Address address
    ) {
        addressService.add(address);

        return "redirect:/address";
    }

    @GetMapping("/editAddress")
    public String editAddress(int id, Model model) throws Exception {

        Address address = addressService.getById(id);

        if (address != null) {
            model.addAttribute("address", address);
            return "editAddress";
        }
        else throw new Exception("Address with id " + id + " does not exist.");
    }

    @PostMapping("/editAddress")
    public String editAddress(
            int id,
            Address address
    ) {
        address.setId(id);
        addressService.add(address);

        return "redirect:/address";
    }

    @RequestMapping(value = "/deleteAddress", method = RequestMethod.DELETE)
    public String deleteAddress(int id) {
        addressService.deleteById(id);
        return "redirect:/address";
    }
}
