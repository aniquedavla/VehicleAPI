package com.VehicleAPI.VehicleAPI.Repositories;

import com.VehicleAPI.VehicleAPI.Entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
