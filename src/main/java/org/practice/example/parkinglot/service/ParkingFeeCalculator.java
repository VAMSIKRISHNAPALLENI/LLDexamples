package org.practice.example.parkinglot.service;

import org.practice.example.parkinglot.entity.Ticket;
import org.practice.example.parkinglot.enums.VehicleType;

public class ParkingFeeCalculator {
    private static final double TWO_WHEELER_RATE = 10.0;
    private static final double FOUR_WHEELER_RATE = 20.0;

    public static double calculateFee(Ticket ticket) {
        long duration = ticket.getParkingDurationInHours();
        VehicleType vehicleType = ticket.getVehicle().getVehicleType();

        switch (vehicleType) {
            case TWO_WHEELER:
                return duration * TWO_WHEELER_RATE;
            case FOUR_WHEELER:
                return duration * FOUR_WHEELER_RATE;
            default:
                return 0.0;
        }
    }
}
