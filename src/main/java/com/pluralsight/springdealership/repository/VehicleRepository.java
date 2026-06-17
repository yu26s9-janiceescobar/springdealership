package com.pluralsight.springdealership.repository;

import com.pluralsight.springdealership.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
