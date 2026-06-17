package com.pluralsight.springdealership.service;

import com.pluralsight.springdealership.model.Dealership;
import com.pluralsight.springdealership.repository.DealershipRepository;
import com.pluralsight.springdealership.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DealershipService {
    private final DealershipRepository dealershipRepository;
    private final VehicleRepository vehicleRepository;
    public DealershipService(DealershipRepository dealershipRepository, VehicleRepository vehicleRepository){
        this.dealershipRepository = dealershipRepository;
        this.vehicleRepository = vehicleRepository;
    }
    public List<Dealership> getAllDealerships(){
        return dealershipRepository.findAll();
    }
    public Dealership findById(Long id){
        return dealershipRepository.findById(id).orElseThrow()
    }
    public Dealership createDealership(Dealership dealership){
        return dealershipRepository.save(dealership);
    }

}
