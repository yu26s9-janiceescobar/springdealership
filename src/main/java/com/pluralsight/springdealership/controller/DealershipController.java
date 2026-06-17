package com.pluralsight.springdealership.controller;
import com.pluralsight.springdealership.model.Dealership;
import com.pluralsight.springdealership.service.DealershipService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dealerships")
public class DealershipController {
    private final DealershipService dealershipService;
    public DealershipController(DealershipService dealershipService){
        this.dealershipService = dealershipService;
    }
    @GetMapping
    public ResponseEntity<List<Dealership>> getAllDealerships(){
        return ResponseEntity.ok(dealershipService.getAllDealerships());
    }
    @PostMapping
    public ResponseEntity<Dealership> createDealership(@RequestBody Dealership dealership){
        dealership = dealershipService.createDealership(dealership);
        return ResponseEntity.status(HttpStatus.CREATED).body(dealership);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Dealership> updateDealership(@PathVariable Long id, @RequestBody Dealership dealership){
        Dealership updated = dealershipService.updateDealership(id, dealership);
        return ResponseEntity.ok(updated);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDealership(@PathVariable Long id){
        dealershipService.deleteDealership(id);
        return ResponseEntity.ok().build();
    }
}
