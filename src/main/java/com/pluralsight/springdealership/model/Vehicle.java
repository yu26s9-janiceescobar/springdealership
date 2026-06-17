package com.pluralsight.springdealership.model;
import jakarta.persistence.*;

import java.math.BigDecimal;


@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vin;

    @ManyToOne
    @JoinColumn(name = "dealership_id")
    private Dealership dealership;

    private Integer year;

    private String make;

    private String model;

    private String vehicleType;

    private String color;

    private Integer odometer;

    private BigDecimal price;

    public Vehicle(){}
    public Vehicle(Long vin, Dealership dealership, Integer year, String make, String model, String vehicleType, String color, Integer odometer, BigDecimal price) {
        this.vin = vin;
        this.dealership = dealership;
        this.year = year;
        this.make = make;
        this.model = model;
        this.vehicleType = vehicleType;
        this.color = color;
        this.odometer = odometer;
        this.price = price;
    }

    public Dealership getDealership() {
        return dealership;
    }

    public void setDealership(Dealership dealership) {
        this.dealership = dealership;
    }

    public void setVin(Long vin) {
        this.vin = vin;
    }

    public Long getVin() {
        return vin;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getOdometer() {
        return odometer;
    }

    public void setOdometer(Integer odometer) {
        this.odometer = odometer;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
