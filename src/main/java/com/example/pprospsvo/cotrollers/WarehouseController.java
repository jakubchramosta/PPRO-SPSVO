package com.example.pprospsvo.cotrollers;

import com.example.pprospsvo.model.Address;
import com.example.pprospsvo.model.Warehouse;
import com.example.pprospsvo.services.AddressService;
import com.example.pprospsvo.services.WarehouseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class WarehouseController {

    private WarehouseService warehouseService;
    private AddressService addressService;

    public WarehouseController(WarehouseService warehouseService, AddressService addressService) {
        this.warehouseService = warehouseService;
        this.addressService = addressService;
    }

    @GetMapping("/warehouse")
    public String warehouse(Model model) {

        List<Warehouse> warehouseList = warehouseService.getWarehouses();
        model.addAttribute("warehouses", warehouseList);
        return "warehouse";
    }

    @GetMapping("/newWarehouse")
    public String newWarehouse(Model model) {
        Warehouse tempWarehouse =  new Warehouse();
        List<Address> addressList = addressService.getAddresses();

        model.addAttribute("warehouse", tempWarehouse);
        model.addAttribute("addressList", addressList);

        return "newWarehouse";
    }

    @PostMapping("/newWarehouse")
    public String newWarehouse(
            Warehouse warehouse
    ) {
        warehouseService.add(warehouse);

        return "redirect:/warehouse";
    }

    @GetMapping("/editWarehouse")
    public String editWarehouse(int id, Model model) throws Exception {

        Warehouse warehouse = warehouseService.getById(id);
        List<Address> addressList = addressService.getAddresses();

        if (warehouse != null) {
            model.addAttribute("warehouse", warehouse);
            model.addAttribute("addressList", addressList);
            return "editWarehouse";
        }
        else throw new Exception("Warehouse with id " + id + " does not exist.");
    }

    @PostMapping("/editWarehouse")
    public String editWarehouse(
            int id,
            Warehouse warehouse
    ) {
        warehouse.setId(id);
        warehouseService.add(warehouse);

        return "redirect:/warehouse";
    }

    @RequestMapping(value = "/deleteWarehouse", method = RequestMethod.DELETE)
    public String deleteWarehouse(int id) {
        warehouseService.deleteById(id);
        return "redirect:/warehouse";
    }
}
