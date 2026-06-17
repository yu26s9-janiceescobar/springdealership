package com.pluralsight.springdealership.controller;

import com.pluralsight.springdealership.model.Vehicle;
import com.pluralsight.springdealership.service.VehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {
    private final VehicleService vehicleService;
    public VehicleController(VehicleService vehicleService){
        this.vehicleService = vehicleService;
    }
    @PostMapping
    public ResponseEntity<Vehicle> createVehicle(Vehicle vehicle){
        vehicle = vehicleService.createVehicle(vehicle);
        return ResponseEntity.status(HttpStatus.CREATED).body(vehicle);
    }
}
