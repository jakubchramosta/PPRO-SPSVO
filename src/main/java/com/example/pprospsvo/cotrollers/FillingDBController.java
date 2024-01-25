package com.example.pprospsvo.cotrollers;

import com.example.pprospsvo.model.*;
import com.example.pprospsvo.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

@Controller
public class FillingDBController {

    private AddressService addressService;
    private CollectionTripService collectionTripService;
    private RPContainerService rpContainerService;
    private VehicleService vehicleService;
    private WarehouseService warehouseService;

    public FillingDBController(AddressService addressService, CollectionTripService collectionTripService, RPContainerService rpContainerService, VehicleService vehicleService, WarehouseService warehouseService) {
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

        Address address7= new Address();
        address7.setPostalCode(51773);
        address7.setCity("Opočno");
        address7.setStreet("Palackého 449/449");

        Address address8= new Address();
        address8.setPostalCode(51773);
        address8.setCity("Opočno");
        address8.setStreet("Družstevní 543");

        Address address9= new Address();
        address9.setPostalCode(51773);
        address9.setCity("Opočno");
        address9.setStreet("U Broumaru 765/765");

        Address address10= new Address();
        address10.setPostalCode(55101);
        address10.setCity("Jaroměř");
        address10.setStreet("Máchova 593");

        Address address11= new Address();
        address11.setPostalCode(55101);
        address11.setCity("Jaroměř");
        address11.setStreet("Na Cihelnách 20");

        Address address12= new Address();
        address12.setPostalCode(55101);
        address12.setCity("Jaroměř");
        address12.setStreet("Jaromírova 80");


        Warehouse warehouse1 = new Warehouse();
        warehouse1.setCapacity(100000);
        warehouse1.setFullness(11);
        warehouse1.setAddress(address1);

        Warehouse warehouse2 = new Warehouse();
        warehouse2.setCapacity(50000);
        warehouse2.setFullness(50);
        warehouse2.setAddress(address4);

        Warehouse warehouse3= new Warehouse();
        warehouse3.setCapacity(50000);
        warehouse3.setFullness(50);
        warehouse3.setAddress(address7);

        Warehouse warehouse4 = new Warehouse();
        warehouse4.setCapacity(250000);
        warehouse4.setFullness(25);
        warehouse4.setAddress(address10);


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

        RPContainer container5 = new RPContainer();
        container5.setCapacity(120);
        container5.setFullness(20);
        container5.setRpType(RPType.AL_cans);
        container5.setAddress(address8);

        RPContainer container6 = new RPContainer();
        container6.setCapacity(250);
        container6.setFullness(50);
        container6.setRpType(RPType.Plastic_bottles);
        container6.setAddress(address9);

        RPContainer container7 = new RPContainer();
        container7.setCapacity(350);
        container7.setFullness(80);
        container7.setRpType(RPType.Glass_bottles);
        container7.setAddress(address11);

        RPContainer container8 = new RPContainer();
        container8.setCapacity(130);
        container8.setFullness(20);
        container8.setRpType(RPType.Wooden_palette);
        container8.setAddress(address12);


        Vehicle vehicle1 = new Vehicle();
        vehicle1.setCapacity(1500);
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
        vehicle2.setWarehouse(warehouse1);
        warehouse1.getVehicleList().add(vehicle2);

        Vehicle vehicle3 = new Vehicle();
        vehicle3.setCapacity(1200);
        vehicle3.setAvailable(true);
        vehicle3.setLicensePlate("6A54321");
        vehicle3.setModel("Iveco");
        vehicle3.setWarehouse(warehouse2);
        warehouse2.getVehicleList().add(vehicle3);

        Vehicle vehicle4 = new Vehicle();
        vehicle4.setCapacity(1100);
        vehicle4.setAvailable(true);
        vehicle4.setLicensePlate("6A54321");
        vehicle4.setModel("Iveco");
        vehicle4.setWarehouse(warehouse3);
        warehouse3.getVehicleList().add(vehicle4);

        Vehicle vehicle5 = new Vehicle();
        vehicle5.setCapacity(1700);
        vehicle5.setAvailable(true);
        vehicle5.setLicensePlate("6A54321");
        vehicle5.setModel("Volvo");
        vehicle5.setWarehouse(warehouse4);
        warehouse4.getVehicleList().add(vehicle5);

        Vehicle vehicle6 = new Vehicle();
        vehicle6.setCapacity(2000);
        vehicle6.setAvailable(true);
        vehicle6.setLicensePlate("6A54321");
        vehicle6.setModel("Volvo");
        vehicle6.setWarehouse(warehouse4);
        warehouse4.getVehicleList().add(vehicle6);


        CollectionTrip collectionTrip1 = new CollectionTrip();
        collectionTrip1.setTripDate(LocalDate.of(2023,5,1));
        collectionTrip1.setUsedVehicle(vehicle1);
        collectionTrip1.getRpContainerList().add(container1);
        collectionTrip1.getRpContainerList().add(container2);

        CollectionTrip collectionTrip2 = new CollectionTrip();
        collectionTrip2.setTripDate(LocalDate.of(2023,6,10));
        collectionTrip2.setUsedVehicle(vehicle2);
        collectionTrip2.getRpContainerList().add(container1);
        collectionTrip2.getRpContainerList().add(container2);

        CollectionTrip collectionTrip3 = new CollectionTrip();
        collectionTrip3.setTripDate(LocalDate.of(2023,2,15));
        collectionTrip3.setUsedVehicle(vehicle3);
        collectionTrip3.getRpContainerList().add(container3);
        collectionTrip3.getRpContainerList().add(container4);

        CollectionTrip collectionTrip4 = new CollectionTrip();
        collectionTrip4.setTripDate(LocalDate.of(2023,3,19));
        collectionTrip4.setUsedVehicle(vehicle4);
        collectionTrip4.getRpContainerList().add(container5);
        collectionTrip4.getRpContainerList().add(container6);

        CollectionTrip collectionTrip5 = new CollectionTrip();
        collectionTrip5.setTripDate(LocalDate.of(2023,7,4));
        collectionTrip5.setUsedVehicle(vehicle5);
        collectionTrip5.getRpContainerList().add(container7);
        collectionTrip5.getRpContainerList().add(container8);



        addressService.add(address1);
        addressService.add(address2);
        addressService.add(address3);
        addressService.add(address4);
        addressService.add(address5);
        addressService.add(address6);
        addressService.add(address7);
        addressService.add(address8);
        addressService.add(address9);
        addressService.add(address10);
        addressService.add(address11);
        addressService.add(address12);

        warehouseService.add(warehouse1);
        warehouseService.add(warehouse2);
        warehouseService.add(warehouse3);
        warehouseService.add(warehouse4);

        rpContainerService.add(container1);
        rpContainerService.add(container2);
        rpContainerService.add(container3);
        rpContainerService.add(container4);
        rpContainerService.add(container5);
        rpContainerService.add(container6);
        rpContainerService.add(container7);
        rpContainerService.add(container8);

        vehicleService.add(vehicle1);
        vehicleService.add(vehicle2);
        vehicleService.add(vehicle3);
        vehicleService.add(vehicle4);
        vehicleService.add(vehicle5);
        vehicleService.add(vehicle6);

        collectionTripService.add(collectionTrip1);
        collectionTripService.add(collectionTrip2);
        collectionTripService.add(collectionTrip3);
        collectionTripService.add(collectionTrip4);
        collectionTripService.add(collectionTrip5);
    }
}