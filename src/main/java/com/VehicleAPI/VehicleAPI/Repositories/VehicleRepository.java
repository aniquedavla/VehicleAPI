package com.VehicleAPI.VehicleAPI.Repositories;

import com.VehicleAPI.VehicleAPI.Entities.Vehicle;
import org.springframework.data.repository.CrudRepository;

public interface VehicleRepository extends CrudRepository<Vehicle, Integer> {

}
