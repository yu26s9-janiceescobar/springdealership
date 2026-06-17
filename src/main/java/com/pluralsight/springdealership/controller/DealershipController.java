package com.pluralsight.springdealership.controller;
import com.pluralsight.springdealership.model.Dealership;
import com.pluralsight.springdealership.service.DealershipService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dealerships")
public class DealershipController {
    private final DealershipService dealershipService;
    public DealershipController(DealershipService dealershipService){
        this.dealershipService = dealershipService;
    }
    @PostMapping
    public ResponseEntity<Dealership> createDealership(@RequestBody Dealership dealership){
        dealership = dealershipService.createDealership(dealership);
        return ResponseEntity.status(HttpStatus.CREATED).body(dealership);
    }
}
