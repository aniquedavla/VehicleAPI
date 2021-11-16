package com.VehicleAPI.VehicleAPI.Controllers;


import com.VehicleAPI.VehicleAPI.Entities.Vehicle;
import com.VehicleAPI.VehicleAPI.Services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Optional;

//VehicleController handles rest calls and communicates with the service class to perform create, update and delete operation for vehicles
@RestController
@RequestMapping(value = "/")
public class VehicleRestController {
    @Autowired
    private VehicleService vehicleService;

    @PostMapping(value = "/addNote")
    public Vehicle createVehicle(@RequestBody Vehicle vehicle) {
        System.out.println(vehicle);
        Vehicle createdVehicle = vehicleService.createVehicle(vehicle);
        return createdVehicle;
    }

    @GetMapping(value = "/vehicles/{vehicleId}")
    public Vehicle getVehicle(@PathVariable("vehicleId") Integer vehicleId){
        return vehicleService.getVehicleById(vehicleId).get();
    }

    @GetMapping(value = "/vehicles")
    public Iterable<Vehicle> getAllVehicles(){
        return vehicleService.getAllVehicle();
    }

    @DeleteMapping(value = "/vehicles/delete/{vehicleId}")
    public void deleteVehicle(@PathVariable("vehicleId") Integer vehicleId){
        vehicleService.deleteVehicle(vehicleId);
    }

    @PutMapping(value = "/vehicles/update")
    public Vehicle updateVehicle(@RequestBody Vehicle vehicle){
        return vehicleService.updateVehicle(vehicle.getId(), vehicle.getYear(), vehicle.getMake(), vehicle.getModel());
    }

    @GetMapping(value = "/getAllVehiclesByMake/{make}")
    public Iterable<Vehicle> getAllVehiclesByMake(@PathVariable("make") String  make){
        return vehicleService.getAllVehiclesByMake(make);
    }

    @GetMapping(value = "/getAllVehiclesByModel/{model}")
    public Iterable<Vehicle> getAllVehiclesByModel(@PathVariable("model") String  model){
        return vehicleService.getAllVehiclesByModel(model);
    }
    @PostMapping(value = "/associate-year")
    public Optional<Vehicle> associateYearOnAvailableModel(@RequestBody HashMap<String, String> requestObj){
        return vehicleService.updateFistAvailableYearByModel(requestObj.get("model"), Integer.valueOf(requestObj.get("year")));
    }
}