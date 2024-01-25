package com.example.pprospsvo.cotrollers;

import com.example.pprospsvo.model.*;
import com.example.pprospsvo.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

@Controller
public class ControllerTest {

    private AddressService addressService;
    private CollectionTripService collectionTripService;
    private RPContainerService rpContainerService;
    private VehicleService vehicleService;
    private WarehouseService warehouseService;

    public ControllerTest(AddressService addressService, CollectionTripService collectionTripService, RPContainerService rpContainerService, VehicleService vehicleService, WarehouseService warehouseService) {
        this.addressService = addressService;
        this.collectionTripService = collectionTripService;
        this.rpContainerService = rpContainerService;
        this.vehicleService = vehicleService;
        this.warehouseService = warehouseService;
    }

    @GetMapping("/dbFill")
    public String dbTest(){
        saveTestData();

        return "dbFill";
    }

    private void saveTestData() {

        Address address1 = new Address();
        address1.setPostalCode(54901);
        address1.setCity("Nové Město nad Metují");
        address1.setStreet("Gen. Klapálka 140/140");

        Address address2 = new Address();
        address2.setPostalCode(54901);
        address2.setCity("Nové Město nad Metují");
        address2.setStreet("Nádražní 352");

        Address address3 = new Address();
        address3.setPostalCode(54901);
        address3.setCity("Nové Město nad Metují");
        address3.setStreet("B. Němcové 720");

        Address address4= new Address();
        address4.setPostalCode(51801);
        address4.setCity("Dobruška");
        address4.setStreet("Nádražní 700");

        Address address5= new Address();
        address5.setPostalCode(51801);
        address5.setCity("Dobruška");
        address5.setStreet("Pulická 1037");

        Address address6= new Address();
        address6.setPostalCode(51801);
        address6.setCity("Dobruška");
        address6.setStreet("Opočenská 470");


        Warehouse warehouse1 = new Warehouse();
        warehouse1.setCapacity(100000);
        warehouse1.setFullness(0);
        warehouse1.setAddress(address1);

        Warehouse warehouse2 = new Warehouse();
        warehouse2.setCapacity(50000);
        warehouse2.setFullness(0);
        warehouse2.setAddress(address4);


        RPContainer container1 = new RPContainer();
        container1.setCapacity(120);
        container1.setFullness(50);
        container1.setRpType(RPType.AL_cans);
        container1.setAddress(address2);

        RPContainer container2 = new RPContainer();
        container2.setCapacity(150);
        container2.setFullness(60);
        container2.setRpType(RPType.Plastic_bottles);
        container2.setAddress(address3);

        RPContainer container3 = new RPContainer();
        container3.setCapacity(100);
        container3.setFullness(80);
        container3.setRpType(RPType.Glass_bottles);
        container3.setAddress(address5);

        RPContainer container4 = new RPContainer();
        container4.setCapacity(150);
        container4.setFullness(70);
        container4.setRpType(RPType.Wooden_palette);
        container4.setAddress(address6);


        Vehicle vehicle1 = new Vehicle();
        vehicle1.setCapacity(1000);
        vehicle1.setAvailable(true);
        vehicle1.setLicensePlate("1A23456");
        vehicle1.setModel("Scania");
        vehicle1.setWarehouse(warehouse1);
        warehouse1.getVehicleList().add(vehicle1);

        Vehicle vehicle2 = new Vehicle();
        vehicle2.setCapacity(1000);
        vehicle2.setAvailable(true);
        vehicle2.setLicensePlate("6A54321");
        vehicle2.setModel("Scania");
        vehicle2.setWarehouse(warehouse2);
        warehouse2.getVehicleList().add(vehicle2);


        CollectionTrip collectionTrip1 = new CollectionTrip();
        collectionTrip1.setTripDate(LocalDate.of(2023,5,1));
        collectionTrip1.setUsedVehicle(vehicle1);
        collectionTrip1.getRpContainerList().add(container1);
        collectionTrip1.getRpContainerList().add(container2);

        CollectionTrip collectionTrip2 = new CollectionTrip();
        collectionTrip2.setTripDate(LocalDate.of(2023,6,10));
        collectionTrip2.setUsedVehicle(vehicle2);
        collectionTrip2.getRpContainerList().add(container3);
        collectionTrip2.getRpContainerList().add(container4);



        addressService.add(address1);
        addressService.add(address2);
        addressService.add(address3);
        addressService.add(address4);
        addressService.add(address5);
        addressService.add(address6);

        warehouseService.add(warehouse1);
        warehouseService.add(warehouse2);

        rpContainerService.add(container1);
        rpContainerService.add(container2);
        rpContainerService.add(container3);
        rpContainerService.add(container4);

        vehicleService.add(vehicle1);
        vehicleService.add(vehicle2);

        collectionTripService.add(collectionTrip1);
        collectionTripService.add(collectionTrip2);
    }
}