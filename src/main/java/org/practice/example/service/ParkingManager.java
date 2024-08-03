package org.practice.example.service;

import org.practice.example.entity.*;
import org.practice.example.enums.VehicleType;

import java.time.LocalDateTime;
import java.util.PriorityQueue;

public class ParkingManager {
    ParkingLot parkingLot;

    public ParkingManager(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public void addParking(){
        parkingLot.addParkingSpot(new ParkingSpot(1,true,new Vehicle(), VehicleType.TWO_WHEELER.getVehicleType()));
        parkingLot.addParkingSpot(new ParkingSpot(2,true,new Vehicle(), VehicleType.TWO_WHEELER.getVehicleType()));
        parkingLot.addParkingSpot(new ParkingSpot(3,true,new Vehicle(), VehicleType.TWO_WHEELER.getVehicleType()));


        parkingLot.addParkingSpot(new ParkingSpot(1,true,new Vehicle(), VehicleType.FOUR_WHEELER.getVehicleType()));
        parkingLot.addParkingSpot(new ParkingSpot(2,true,new Vehicle(), VehicleType.FOUR_WHEELER.getVehicleType()));
        parkingLot.addParkingSpot(new ParkingSpot(3,true,new Vehicle(), VehicleType.FOUR_WHEELER.getVehicleType()));
    }

    public void removeParkingSpot(){
        parkingLot.removeParkingSpot(new ParkingSpot(1,true,new Vehicle(), VehicleType.TWO_WHEELER.getVehicleType()));
    }

    public void vehicleEnter(){
        Vehicle vehicle = new Vehicle(VehicleType.FOUR_WHEELER,"AP029696");
        ParkingSpot nearestParkingSpot = parkingLot.getEntryPoint().getNearestParkingSpot(vehicle.getVehicleType());
        Ticket ticket = new Ticket("1", LocalDateTime.now(),null,vehicle,nearestParkingSpot,0);



    }
}
