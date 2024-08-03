package org.practice.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.practice.example.enums.VehicleType;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
    VehicleType vehicleType;
    String licensePlate;
}
