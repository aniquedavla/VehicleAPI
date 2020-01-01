package com.VehicleAPI.VehicleAPI.Controllers;


import com.VehicleAPI.VehicleAPI.Entities.Vehicle;
import com.VehicleAPI.VehicleAPI.Services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//VehicleController handles rest calls and communicates with the service class to perform create, update and delete operation for vehicles
@RestController
@RequestMapping(value = "api/")
public class VehicleRestController {
    @Autowired
    private VehicleService vehicleService;

    @PostMapping(value = "/create")
    public Vehicle createVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.createVehicle(vehicle);
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
}