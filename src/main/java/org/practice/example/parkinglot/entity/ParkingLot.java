package org.practice.example.parkinglot.entity;

import lombok.Data;

import java.util.PriorityQueue;

@Data
public class ParkingLot {
    EntryPoint entryPoint;

    ExistPoint existPoint;
    public ParkingLot(EntryPoint entryPoint) {
        this.entryPoint = entryPoint;
    }

    public void addParkingSpot(ParkingSpot parkingSpot){
        if(!this.entryPoint.getParkingSpotsMap().containsKey(parkingSpot.getVehicleParkingType()))
            this.entryPoint.getParkingSpotsMap().put(parkingSpot.getVehicleParkingType(), new PriorityQueue<>());
        this.entryPoint.getParkingSpotsMap().get(parkingSpot.getVehicleParkingType()).add(parkingSpot);
    }

    public String removeParkingSpot(ParkingSpot parkingSpot){
        if(!this.entryPoint.getParkingSpotsMap().containsKey(parkingSpot.getVehicleParkingType()))
            return "Nothing Found";
        this.entryPoint.getParkingSpotsMap().get(parkingSpot.getVehicleParkingType()).remove(parkingSpot);
        return "Found";
    }


}
