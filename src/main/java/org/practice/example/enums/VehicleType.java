package org.practice.example.enums;

public enum VehicleType {
    TWO_WHEELER("Two Wheeler"),
    FOUR_WHEELER("Four Wheeler");

    String vehicleType;

    VehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleType() {
        return vehicleType;
    }
}
