package com.pluralsight.springdealership.service;
import com.pluralsight.springdealership.exception.ResourceNotFoundException;
import com.pluralsight.springdealership.model.Dealership;
import com.pluralsight.springdealership.repository.DealershipRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DealershipService {

    private final DealershipRepository dealershipRepository;

    public DealershipService(DealershipRepository dealershipRepository){
        this.dealershipRepository = dealershipRepository;
    }

    public Dealership createDealership(Dealership dealership){
        return dealershipRepository.save(dealership);
    }

    public List<Dealership> getAllDealerships(){
        return dealershipRepository.findAll();
    }
    public Dealership updateDealership(Long id, Dealership dealership){
        return dealershipRepository.findById(id)
                .map(existing -> {
                    existing.setAddress(dealership.getAddress());
                    existing.setName(dealership.getName());
                    existing.setPhoneNumber(dealership.getPhoneNumber());
                    return dealershipRepository.save(existing);
                }).orElseThrow(() -> new ResourceNotFoundException("Dealership not Found: " + id));
    }
    public void deleteDealership(Long id){
        if (!dealershipRepository.existsById(id)){
            throw new ResourceNotFoundException("Dealership not Found: " + id);
        }
        dealershipRepository.deleteById(id);
    }
    public Dealership findById(Long id){
        return dealershipRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Dealership Not Found: " + id));
    }

}
