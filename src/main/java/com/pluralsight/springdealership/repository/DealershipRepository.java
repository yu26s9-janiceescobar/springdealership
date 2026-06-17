package com.pluralsight.springdealership.repository;

import com.pluralsight.springdealership.model.Dealership;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DealershipRepository extends JpaRepository<Dealership, Long> {

}
