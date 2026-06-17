package com.pluralsight.springdealership.repository;

import com.pluralsight.springdealership.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    List<Vehicle> findByDealershipId(Long id);
}
