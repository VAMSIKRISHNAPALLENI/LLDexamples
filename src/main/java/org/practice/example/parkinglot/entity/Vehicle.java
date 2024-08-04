package org.practice.example.parkinglot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.practice.example.parkinglot.enums.VehicleType;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
    VehicleType vehicleType;
    String licensePlate;
}
