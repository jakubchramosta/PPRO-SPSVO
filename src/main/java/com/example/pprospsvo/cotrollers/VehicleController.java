package com.example.pprospsvo.cotrollers;

import com.example.pprospsvo.model.Address;
import com.example.pprospsvo.model.Vehicle;
import com.example.pprospsvo.model.Warehouse;
import com.example.pprospsvo.services.VehicleService;
import com.example.pprospsvo.services.WarehouseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class VehicleController {

    private VehicleService vehicleService;
    private WarehouseService warehouseService;

    public VehicleController(VehicleService vehicleService, WarehouseService warehouseService) {
        this.vehicleService = vehicleService;
        this.warehouseService = warehouseService;
    }

    @GetMapping("/vehicle")
    public String vehicle(Model model) {

        List<Vehicle> vehicleList = vehicleService.getVehicles();
        model.addAttribute("vehicleList", vehicleList);
        return "vehicle";
    }

    @GetMapping("/newVehicle")
    public String newVehicle(Model model) {
        Vehicle tempVehicle =  new Vehicle();
        List<Warehouse> warehouseList = warehouseService.getWarehouses();

        model.addAttribute("vehicle", tempVehicle);
        model.addAttribute("warehouseList", warehouseList);

        return "newVehicle";
    }

    @PostMapping("/newVehicle")
    public String newVehicle(
            Vehicle vehicle
    ) {
        vehicleService.add(vehicle);

        return "redirect:/vehicle";
    }

    @GetMapping("/editVehicle")
    public String editVehicle(int id, Model model) throws Exception {

        Vehicle vehicle = vehicleService.getById(id);
        List<Warehouse> warehouseList = warehouseService.getWarehouses();

        if (vehicle != null) {
            model.addAttribute("vehicle", vehicle);
            model.addAttribute("warehouseList", warehouseList);
            return "editVehicle";
        }
        else throw new Exception("Vehicle with id " + id + " does not exist.");
    }

    @PostMapping("/editVehicle")
    public String editVehicle(
            int id,
            Vehicle vehicle
    ) {
        vehicle.setId(id);
        vehicleService.add(vehicle);

        return "redirect:/vehicle";
    }

    @RequestMapping(value = "/deleteVehicle", method = RequestMethod.DELETE)
    public String deleteVehicle(int id) {
        vehicleService.deleteById(id);
        return "redirect:/vehicle";
    }
}
