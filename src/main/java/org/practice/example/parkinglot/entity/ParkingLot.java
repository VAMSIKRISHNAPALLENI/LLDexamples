package org.practice.example.parkinglot.entity;

import lombok.Data;
import org.practice.example.parkinglot.service.ParkingFeeCalculator;
import org.springframework.stereotype.Component;

import java.util.PriorityQueue;

@Data
@Component
public class ParkingLot {
    EntryPoint entryPoint;

    ExistPoint existPoint;

    ParkingFeeCalculator parkingFeeCalculator; // can use Strategy pattern to pick Algo
    public ParkingLot(EntryPoint entryPoint) {
        this.entryPoint = entryPoint;
    }

    public void addParkingSpot(ParkingSpot parkingSpot){
        if(!this.entryPoint.getParkingSpotsMap().containsKey(parkingSpot.getVehicleParkingType()))
            this.entryPoint.getParkingSpotsMap().put(parkingSpot.getVehicleParkingType(), new PriorityQueue<>((a,b)->(a.getParkingSpotId()- b.getParkingSpotId())));
        this.entryPoint.getParkingSpotsMap().get(parkingSpot.getVehicleParkingType()).add(parkingSpot);
    }

    public String removeParkingSpot(ParkingSpot parkingSpot){
        if(!this.entryPoint.getParkingSpotsMap().containsKey(parkingSpot.getVehicleParkingType()))
            return "Nothing Found";
        this.entryPoint.getParkingSpotsMap().get(parkingSpot.getVehicleParkingType()).remove(parkingSpot);
        return "Found and removed";
    }

    public void prePaymentProcess(Ticket ticket){
       ticket.setExitTime();
       Double parkingFee = parkingFeeCalculator.calculateFee(ticket);
       ticket.setTotalAmount(parkingFee);
    }
    public String postPaymentProcess(Ticket ticket){
       try {
            Vehicle vehicle = ticket.getVehicle();
            ParkingSpot parkingSpot = ticket.getParkingSpot();
            this.entryPoint.getParkingSpotsMap().get(parkingSpot.getCurrVehicle().getVehicleType()).add(parkingSpot);
            return "You can Exist";
        }
       catch (Exception e){
           return "Something Went Wrong contact Manager";
        }
    }
}
