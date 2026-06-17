package com.pluralsight.springdealership.service;
import com.pluralsight.springdealership.exception.ResourceNotFoundException;
import com.pluralsight.springdealership.model.Vehicle;
import com.pluralsight.springdealership.repository.DealershipRepository;
import com.pluralsight.springdealership.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {
    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }
    public List<Vehicle> getAllVehicles(){
        return vehicleRepository.findAll();
    }
    public Vehicle getVehicleById(Long id){
        return vehicleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle Not Found: " + id));
    }
    public Vehicle createVehicle(Vehicle vehicle){
        return vehicleRepository.save(vehicle);
    }
    public void deleteVehicle(Long id){
        if (!vehicleRepository.existsById(id)){
            throw new ResourceNotFoundException("Vehicle Not Found: " + id);
        }
        vehicleRepository.deleteById(id);
    }
    public Vehicle updateVehicle(Long id, Vehicle updatedVehicle){
        return vehicleRepository.findById(id).map( existing -> {
            existing.setYear(updatedVehicle.getYear());
            existing.setColor(updatedVehicle.getColor());
            existing.setVehicleType(updatedVehicle.getVehicleType());
            existing.setMake(updatedVehicle.getMake());
            existing.setModel(updatedVehicle.getModel());
            existing.setOdometer(updatedVehicle.getOdometer());
            existing.setPrice(updatedVehicle.getPrice());
            existing.setDealership(updatedVehicle.getDealership());
            return vehicleRepository.save(existing);
        }).orElseThrow(() -> new ResourceNotFoundException("Vehicle Not Found: "+ id));
    }
    public List<Vehicle> getVehiclesByDealershipId(Long id){
        return vehicleRepository.findByDealershipId(id);
    }
}
