package org.practice.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.practice.example.enums.VehicleType;
@Data
@AllArgsConstructor
public class ParkingSpot {
    int parkingSpotId;
    boolean isAvailable;
    Vehicle currVehicle;
    String vehicleParkingType;


}
