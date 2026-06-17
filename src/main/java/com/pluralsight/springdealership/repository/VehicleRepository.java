package com.pluralsight.springdealership.repository;

import com.pluralsight.springdealership.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    List<Vehicle> findByDealershipId(Long id);
    @Query("""
    SELECT v FROM Vehicle v
        WHERE (:make IS NULL OR v.make = :make)
        AND (:color IS NULL OR v.color = :color)
        AND (:vehicleType IS NULL OR v.vehicleType = :vehicleType)
        AND (:model IS NULL OR v.model = :model)
        AND (:minPrice IS NULL OR v.price >= :minPrice)
        AND (:maxPrice IS NULL OR v.price <= :maxPrice)
        AND (:minMiles IS NULL OR v.odometer >= :minMiles)
        AND (:maxMiles IS NULL OR v.odometer <= :maxMiles)
        AND (:minYear IS NULL OR v.year >= :minYear)
        AND (:maxYear IS NULL OR v.year <= :maxYear)
    """)
    List<Vehicle> searchVehicles(
            @Param("minPrice") BigDecimal minPrice,
            @Param("maxPrice") BigDecimal maxPrice,
            @Param("minMiles") Integer minMiles,
            @Param("maxMiles") Integer maxMiles,
            @Param("minYear") Integer minYear,
            @Param("maxYear") Integer maxYear,
            @Param("color") String color,
            @Param("make") String make,
            @Param("model") String model,
            @Param("vehicleType") String vehicleType);
}

