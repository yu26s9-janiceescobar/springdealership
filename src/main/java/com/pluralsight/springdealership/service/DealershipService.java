package com.pluralsight.springdealership.service;
import com.pluralsight.springdealership.exception.DealershipNotFoundException;
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

    public Dealership findById(Long id){
        return dealershipRepository.findById(id)
                .orElseThrow(() -> new DealershipNotFoundException("Dealership Not Found."));
    }

}
