package org.practice.example.entity;

import lombok.Data;
import org.practice.example.enums.VehicleType;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

@Data
public class EntryPoint {
    String entryId;
    Map<String,PriorityQueue<ParkingSpot>>  parkingSpotsMap= new HashMap<>();

    public ParkingSpot getNearestParkingSpot(VehicleType vehicleType){
        String typeOfParkingSpot = vehicleType.getVehicleType();
        if(parkingSpotsMap.containsKey(typeOfParkingSpot)){
            return parkingSpotsMap.get(typeOfParkingSpot).poll();
        }
        return null;
    }
}
