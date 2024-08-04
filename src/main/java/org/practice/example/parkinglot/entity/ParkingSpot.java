package org.practice.example.parkinglot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ParkingSpot {
    int parkingSpotId;
    boolean isAvailable;
    Vehicle currVehicle;
    String vehicleParkingType;


}
