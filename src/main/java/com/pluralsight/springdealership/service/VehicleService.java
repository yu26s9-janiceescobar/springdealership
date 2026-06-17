package com.pluralsight.springdealership.service;
import com.pluralsight.springdealership.model.Vehicle;
import com.pluralsight.springdealership.repository.DealershipRepository;
import com.pluralsight.springdealership.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {
    private VehicleRepository vehicleRepository;
    private DealershipRepository dealershipRepository;

    public VehicleService(VehicleRepository vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }
    public List<Vehicle> getAllVehicles(){
        return vehicleRepository.findAll();
    }
    public Vehicle createVehicle(Vehicle vehicle){
        return vehicleRepository.save(vehicle);
    }
    public List<Vehicle> getVehiclesByDealershipId(Long id){
        return vehicleRepository.findByDealershipId(id);
    }
}
