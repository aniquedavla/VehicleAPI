package com.VehicleAPI.VehicleAPI.Services;

import com.VehicleAPI.VehicleAPI.Entities.Vehicle;
import com.VehicleAPI.VehicleAPI.Repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

//VehicleService communicates with data repository wrapper to create, update and delete appropriate data about vehicle.
@Service
public class VehicleService {
    //injects VehicleRepo when the controller starts
    @Autowired
    private VehicleRepository vehicleRepo;

    //stores the vehicle using data repo function
    public Vehicle createVehicle(Vehicle vehicle){
        return vehicleRepo.save(vehicle);
    }

    //retrieves a vehicle using the vehicle id
    public Optional<Vehicle> getVehicleById(Integer vehicleId){
        return vehicleRepo.findById(vehicleId);
    }

    //retrieves an iterable data of all vehicles
    public Iterable<Vehicle> getAllVehicle(){
        return  vehicleRepo.findAll();
    }

    //deletes a vehicle using the vehicle id
    public void deleteVehicle(Integer vehicleId){
        vehicleRepo.deleteById(vehicleId);
    }

    //finds a vehicle by ID to update and returns the updated vehicle object
    public Vehicle updateVehicle(int vehicleId, Integer updatedYear, String updatedMake, String updatedModel){
        Optional<Vehicle> vehicle = vehicleRepo.findById(vehicleId);
        if(vehicle.isPresent()){
            vehicle.get().setYear(updatedYear);
            vehicle.get().setMake(updatedMake);
            vehicle.get().setModel(updatedModel);
        }
        Vehicle updatedVehicle = vehicleRepo.save(vehicle.get());
        return updatedVehicle;
    }
}
