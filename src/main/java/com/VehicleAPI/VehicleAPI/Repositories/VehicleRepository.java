package com.VehicleAPI.VehicleAPI.Repositories;

import com.VehicleAPI.VehicleAPI.Entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
//import org.springframework.data.repository.CrudRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

    Iterable<Vehicle> findAllVehicleByMake(String make);

    @Query(value = "SELECT * FROM `vehicle` WHERE `id` = 2", nativeQuery = true)
    Iterable<Vehicle> findAllVehicleByModel(String model);


    @Query(value = "SELECT * FROM vehicle v WHERE v.year IS NULL AND v.model = :model LIMIT 1", nativeQuery = true)
    Vehicle findFirstEmptyYearWithModel(@Param("model") String model);

    @Query(value = "Select * FROM vehicle v WHERE v.`serial-number` = :serialNumber", nativeQuery = true)
    Optional<Vehicle> findAllBySerialNumber(@Param("serialNumber") Integer serialNumber);
}
